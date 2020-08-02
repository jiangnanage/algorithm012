# 第一周学习笔记

### 五毒神掌 五遍刷题法 (每道题至少做5遍以上)：
1. 第一遍5-10读题思考；
2. 有思路：自己开始写代码；不然马上看题解，默写背诵熟练；
3. 第二遍开始自己写（闭卷）；
4. 第三遍隔天再做一遍；
5. 第四/五遍隔一周或者定期再复盘一下

### 解题四件套： 先了解清楚题意；尽可能多的想不同题解；分析最优的解题；再写再测试
自顶向下编程方式  
最大误区：做题只做一遍  
优化思想：空间换时间、升维  

### 时间复杂度
* O(1)
* O(logn)
* O(n)
* O(n^2)
* O(n^3)
* O(2^n)
* O(n!)

### 主定理：
* 二分查找  T(n)=T(n/2)+O(1)   O(logn)
* 二叉树    T(n)=2T(n/2)+O(1)		O(n)
* 二维矩阵	T(n)=2T(n/2)+O(logn)		O(n)
* merge sort T(n)=2T(n/2)+O(n)		O(nlogn)

### 空间复杂度 有关 1数组长度 2递归的深度

### 数组(Array)、链表(LinkedList)、跳表(SkipList)
Array 		 	时间复杂度 	查询O(1) 增删O(n)  
LinkedList 	时间复杂度 	查询O(n) 增删O(1)  
							prepend		append		lookup		insert		delete
Array						O(1)			O(1)			O(1)			O(n)			O(n)  
LinkedList			O(1)			O(1)			O(n)			O(1)			O(1)  
跳表特点 只能用于元素有序的情况 对标平衡树（AVL Tree）和二分查找是一种 插入/删除/搜索都是O(logn)数据结构  
一维的数据结构加速方式——升维 变成二维数据结构  
添加多级索引  
跳表查询的时间复杂度分析  
n/2 n/4 n/8 第k及索引结点的个数就是  n/(2^k)  
假设索引有h级，最高级索引有2个结点  n/(2^h) = 2   从而求得 h = log2(n)-1  
空间复杂度都是O(n)  

### 栈(stack) 队列(queue) 双端队列(Deque) 优先队列(priority queue)
stack  先进后出  增删 O(1) 查询O(n)  
queue 先进先出  增删 O(1) 查询O(n)  
Deque 增删 O(1) 查询O(n)  
priority queue 插入O(1) 取出 O(logn) 按照元素的优先级取出 底层数据结构 heap bst treap  
最近相关性——使用stack解决  
先来后到——使用queue解决  
