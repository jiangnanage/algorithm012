# 学习笔记：
HashMap继承于AbstractMap，实现了Map、Cloneable、Serializable接口，它存储的内容是键值对的映射（无序）。它的实现是不同步的，意味着它不是线程安全的。它的key、value都可以为null。

大方向上：HashMap里面是一个数组，数组中的每个元素都是一个单向链表。总体结构为数组+链表。

capacity：当前数组容量，始终保持2^n,可以扩容，扩容后数组大小为当前的2倍。

loadFactor:负载因子，默认为0.75。

threshold：扩容的阔值，等于capacity*loadFactor  

HashMap 的Api：  
void                 clear()//清空HashMap  
Object               clone()//克隆HashMap  
boolean              containsKey(Object key)//判断HashMap是否包含key  
boolean              containsValue(Object value)//判断HashMap是否包含值为value的元素  
Set<Entry<K, V>>     entrySet()  
V                    get(Object key)  
boolean              isEmpty()  
Set<K>               keySet()  
V                    put(K key, V value)  
void                 putAll(Map<? extends K, ? extends V> map)  
V                    remove(Object key)  
int                  size()  
Collection<V>        values()  

put方法：
~~~
public V put(K key, V value) {
    // 当插入第一个元素的时候，需要先初始化数组大小
    if (table == EMPTY_TABLE) {
        inflateTable(threshold);
    }
    // 如果 key 为 null，最终会将这个 entry 放到 table[0] 中
    if (key == null)
        return putForNullKey(value);
    // 1. 求 key 的 hash 值
    int hash = hash(key);
    // 2. 找到对应的数组下标
    int i = indexFor(hash, table.length);
    // 3. 遍历一下对应下标处的链表，看是否有重复的 key 已经存在，
    //    如果有，直接覆盖，put 方法返回旧值就结束了
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
 
    modCount++;
    // 4. 不存在重复的 key，将此 entry 添加到链表中
    addEntry(hash, key, value, i);
    return null;
}

如果当前插入元素为第一个元素的时候，需要对数组大小进行初始化 inflatable（），确认数组的初始大小，并计算数组扩容的阈值。

private void inflateTable(int toSize) {
    // 保证数组大小一定是 2 的 n 次方。
    int capacity = roundUpToPowerOf2(toSize);
    // 计算扩容阈值：capacity * loadFactor
    threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
    table = new Entry[capacity];
    initHashSeedAsNeeded(capacity); //ignore
}

如果当前插入元素的key值于链表中的key没有重复的话，进行addEntry（）操作，如果重复了直接覆盖。

void addEntry(int hash, K key, V value, int bucketIndex) {
    // 如果当前 HashMap 大小已经达到了阈值，并且新值要插入的数组位置已经有元素了，那么要扩容
    if ((size >= threshold) && (null != table[bucketIndex])) {
        // 扩容
        resize(2 * table.length);
        // 扩容以后，重新计算 hash 值
        hash = (null != key) ? hash(key) : 0;
        // 重新计算扩容后的新的下标
        bucketIndex = indexFor(hash, table.length);
    }
    // 往下看
    createEntry(hash, key, value, bucketIndex);
}
// 这个很简单，其实就是将新值放到链表的表头，然后 size++
void createEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K,V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<>(hash, key, value, e);
    size++;
}
~~~
get方法：
过程：根据key计算出hash值，找到相应的数组下标（hash&（length-1）），遍历该数组位置的链表直到找到相等的key。
~~~
public V get(Object key) {
    // 之前说过，key 为 null 的话，会被放到 table[0]，所以只要遍历下 table[0] 处的链表就可以了
    if (key == null)
        return getForNullKey();
    // 
    Entry<K,V> entry = getEntry(key);
 
    return null == entry ? null : entry.getValue();
}
final Entry<K,V> getEntry(Object key) {
    if (size == 0) {
        return null;
    }
 
    int hash = (key == null) ? 0 : hash(key);
    // 确定数组下标，然后从头开始遍历链表，直到找到为止
    for (Entry<K,V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next) {
        Object k;
        if (e.hash == hash &&
            ((k = e.key) == key || (key != null && key.equals(k))))
            return e;
    }
    return null;
}
~~~
HashMap的扩容是非常耗时的，每次扩容会伴随着一次重新分配hash，并且会遍历hash表中的所有元素，所以jdk1.8给HashMap新增了红黑树用于增加HashMap的扩容速度。HashMap的结构变为（数组+链表+红黑树），桶中的数据可能是链表，也可能是红黑树。在我们应用HashMap的过程中应该尽量避免resize。
