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

### 1. 数组、链表、跳表的基本实现和特性
#### 参考链接
- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
- [Linked List 的标准实现代码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
- [LRU Cache - Linked list： LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
- [Redis - Skip List：跳跃表、为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](https://www.zhihu.com/question/20202931)
### 2. 实战题目解析：移动零
### 3. 实战题目解析：盛水最多的容器、爬楼梯
### 4. 实战题目解析：3数之和、环形链表
#### Array 实战题目
- [两数之和](https://leetcode-cn.com/problems/two-sum/)（近半年内，字节跳动在面试中考查此题达到 152 次）
- [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)（腾讯、百度、字节跳动在近半年内面试常考）
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)（华为、字节跳动在近半年内面试常考）
- [爬楼梯](https://leetcode.com/problems/climbing-stairs/)（阿里巴巴、腾讯、字节跳动在半年内面试常考）
- [三数之和](https://leetcode-cn.com/problems/3sum/)（国内、国际大厂历年面试高频老题）
#### Linked List 实战题目
- [反转链表](https://leetcode.com/problems/reverse-linked-list/)（字节跳动、亚马逊在半年内面试常考）
- [两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs/)（阿里巴巴、字节跳动在半年内面试常考）
- [环形链表](https://leetcode.com/problems/linked-list-cycle/)（阿里巴巴、字节跳动、腾讯在半年内面试常考）
- [环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)（字节跳动、猿辅导在半年内面试常考）
### 5. 栈和队列的实现与特性
#### 参考链接
- [Java 的 PriorityQueue 文档](https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)
- [Java 的 Stack 源码](http://developer.classpath.org/doc/java/util/Stack-source.html)
- [Java 的 Queue 源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)
- [Python 的 heapq](https://docs.python.org/2/library/heapq.html)
- [高性能的 container 库](https://docs.python.org/2/library/collections.html)
### 6. 实战题目解析：有效的括号、最小栈等问题
#### 预习题目
- [有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)（亚马逊、JPMorgan 在半年内面试常考）
- [最小栈](https://leetcode-cn.com/problems/min-stack/)（亚马逊在半年内面试常考）
#### 实战题目
- [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)（亚马逊、微软、字节跳动在半年内面试中考过）
- [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)（亚马逊在半年内面试常考）
### 本周作业
#### 简单：
- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
- 分析 Queue 和 Priority Queue 的源码
- [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)（Facebook、字节跳动、微软在半年内面试中考过）
- [旋转数组](https://leetcode-cn.com/problems/rotate-array/)（微软、亚马逊、PayPal 在半年内面试中考过）
- [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)（亚马逊、字节跳动在半年内面试常考）
- [合并两个有序数组](https://github.com/jiangnanage/algorithm012/edit/master/Week_01/README.md)（Facebook 在半年内面试常考）
- [两数之和](https://leetcode-cn.com/problems/two-sum/)（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考）
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)（Facebook、亚马逊、苹果在半年内面试中考过）
- [加一](https://leetcode-cn.com/problems/plus-one/)（谷歌、字节跳动、Facebook 在半年内面试中考过）
中等：
- [设计循环双端队列](https://leetcode.com/problems/design-circular-deque/)（Facebook 在 1 年内面试中考过）
困难：
- [接雨水](https://leetcode.com/problems/trapping-rain-water/)（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）
