# 毕业总结

70天一下子就过去了，虽然课程结束了，但是自己的算法学习才刚开始。课上老师讲的很多高级数据结构都还没吃透，很多练习题也没按老师说的过遍数，所以即使课程结束了我还需要好好巩固前面学习的知识点。  

### 五毒神掌 五遍刷题法 (每道题至少做5遍以上)：
1. 第一遍不要死磕，要看代码学习（一定要看国际版的高票回答）；
2. 有思路：自己开始写代码；不然马上看题解，默写背诵熟练；
3. 24h后第二遍开始自己写（闭卷）；
4. 第三遍隔天或者一周后再做一遍（时间紧的话，就只需要看脑图）；
5. 第四/五遍隔一周或者面试前再复盘一下

### 解题四件套： 先了解清楚题意；尽可能多的想不同题解；分析最优的解题；再写再测试
自顶向下编程方式  
最大误区：做题只做一遍  
优化思想：空间换时间、升维  

### 数据结构

- **一维**      
  - **基础**：数组 array，链表 linked list
  - **高级**：栈 stack， 队列 queue，双端队列 deque，集合 set，映射 map (hash) TreeMap、HashMap
- **二维**  
  - **基础**：树 tree，图 graph
  - **高级**：二叉搜索树 binary search tree(red-black tree,AVL)，堆 heap，并查集 disjoint set，字典树 trie
- **特殊**  
  - 位运算 Bitwise，布隆过滤器 BloomFilter
  - LRU Cache
  
### 复杂度分析

数据结构 | Access | Search | Insertion | Deletion
---|---|---|---|---
Array | O(1) | O(n) | O(n) | O(n) 
Stack | O(n) | O(n) | O(1) | O(1) 
Queue | O(n) | O(n) | O(1) | O(1) 
Singly-Linked List | O(n) | O(n) | O(1) | O(1)
Doubly-Linked List | O(n) | O(n) | O(1) | O(1)
Skip List | O(logN) | O(logN) | O(logN) | O(logN)
Hash Table | N/A | O(1) | O(1) | O(1)
Binary Search Tree | O(logN) | O(logN) | O(logN) | O(logN)
Cartesian Tree | N/A | O(logN) | O(logN) | O(logN)
B-Tree | O(logN) | O(logN) | O(logN) | O(logN)
Read-Black Tree | O(logN) | O(logN) | O(logN) | O(logN)
Splay Tree | N/A | O(logN) | O(logN) | O(logN)
AVL Tree | O(logN) | O(logN) | O(logN) | O(logN)
KD Tree | O(logN) | O(logN) | O(logN) | O(logN)

### 排序算法复杂度

排序方法 | 时间复杂度(平均) | 时间复杂度(最坏) | 时间复杂度(最好) | 空间复杂度 | 稳定性 
---|---|---|---|---|---
插入排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定  
希尔排序 | O(n^1.3) | O(n^2) | O(n) | O(1) | 不稳定
选择排序 | O(n^2) | O(n^2) | O(n^2) | O(1) | 不稳定
堆排序 | O(nlog2^n)  | O(nlog2^n) | O(nlog2^n) | O(1) | 不稳定
冒泡排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定
快速排序 | O(nlog2^n)  | O(n^2) | O(nlog2^n)  | O(nlog2^n) | 不稳定
归并排序 | O(nlog2^n)  | O(nlog2^n) | O(nlog2^n) | O(n) | 稳定
计数排序 | O(n+k) | O(n+k) | O(n+k) | O(n+k) | 稳定
桶排序 | O(n+k) | O(n^2) | O(n) | O(n+k) | 稳定
基数排序 | O(n*k) | O(n*k) | O(n*k) | O(n+k) | 稳定

### 化繁为简的思想
1. 人肉递归低效、很累-> 画出递归的状态树
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳思维

### 学习要点
- 基本功是区别业余和职业选手的根本。深厚功底来自于——过遍数
- 最大的误区：只做一遍
- 五毒神掌
- 刻意练习 - 练习缺陷弱点地方、不舒服、枯燥
- 反馈-看题解、看国际版的高票回答

### 代码模板

#### 递归模板
``` java
public void recur(int level,int param){

	//terminator 递归终结条件
	if (level > MAX_LEVEL){
		//process result
		return;
	}
	
	//process current logic 处理当前层逻辑
	process(level,param);
	
	//drill down 下探到下一层
	recur(level:level+1,newParam);
	
	//restore current status 清理当前层
}
```
#### DFS模板
``` java
  //两个子节点递归模板
	void dfs(TreeNode treeNode){
		if (treeNode == null)
  			return null;
		dfs(treeNode.left);
		dfs(treeNode.right);
	}
  
  //多个子节点递归模板
  visited = set()
	def dfs(node,visited):
		visited.add(node)
		#process current node here
		...
		for next_node in node.children():
			if not next_node in visited:
				dfs(next_node,visited)
        
   //非递归模板
   def dfs(self,tree):
		if tree.node is None:
			return []
		visited, stack = [], [tree.root]
		while stack:
			node = stack.pop()
			visited.add(node)
			process(node)
			nodes = generate_related_nodes(node)
			stack.push(nodes)
```
#### BFS模板
``` java
void bfs(TreeNode node){
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(node.root);
		while (queue != null){
			TreeNode node = queue.poll();
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);		
		}
	}
```

#### 二分查找模板
``` java
left,right = 	0,len(array)-1
		while left<=right:
			mid = (left+right)/2
			if array[mid] == target:
				# find the target!!
				break or return result
			else if array[mid] <= target:
				left = mid + 1
			else
				right = mid -1
```
#### 分治模板
``` java
public int divide_conquer(Problem problem){
		if (problem == null){
			int res = process_result();
			return  res;
		}
		subProblems = split_problem(problem);
		
		res0 = 	divide_conquer(subProblems[0]);
		res1 = 	divide_conquer(subProblems[1]);
		res2 = 	divide_conquer(subProblems[2]);
		...
		result = process_result(res0,res1,res2);
		return result;
	}
```
#### Trie 树模板
``` java
class Trie{
		private boolean isEnd;
		private Trie[] next;
		/**Initialize your data structure here */
		public Trie() {
			isEnd = false;
			next = new Trie[26];
		}
		
		/**Inserts a word into the trie */
		public void insert(String word){
			if (word == null || word.length() == 0)
				return;
			Trie curr = this;
			char[] words = word.toCharArray();
			for (int i = 0; i < words.length; i++){
				int n = word[i] - 'a';
				if (curr.next[n] == null) curr.next[n] = new Trie();
				curr = curr.next[n];
			}
			curr.isEnd = true;
		}

		/** Returns if the word is in the trie */
		public boolean searchWord(String word){
			Trie node = searchPrefix(word);
			return node != null && node.isEnd;
		}

		/** Return if there is any word in the trie that starts with the given prefix */
		public boolean startsWith(String prefix){
			Trie node = searchPrefix(word);
			return node != null;
		}
		
		private Trie searchPrefix(String word){
			Trie node = this;
			char[] words = word.toCharArray();
			for (int i = 0; i < words.length; i++){
				int n = words[i] - 'a';
				node = node.next[n];
				if (node == null) return false;
			}
			return node;
		}

	}

```
#### 并查集模板
``` java
class UnionFind {
		private int count = 0;
		private int[] parent;
		public UnionFind(int n){
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++){
				parent[i] = i;
			}
		}
		
		public int find(int p){
			while(p != parent[p]){
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}

		public void union(int p,int q){
			int rootp = find(p);
			int rootq = find(q);
			if (rootp == rootq) return;
			parent[rootp] = rootq;
			count--;	
		}
	}
```
#### 启发式搜索 A* 代码模板
``` java
public class AStar
	{
		public final static int BAR = 1; // 障碍值
		public final static int PATH = 2; // 路径
		public final static int DIRECT_VALUE = 10; // 横竖移动代价
		public final static int OBLIQUE_VALUE = 14; // 斜移动代价
		
		Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
		List<Node> closeList = new ArrayList<Node>();
		
		/**
		 * 开始算法
		 */
		public void start(MapInfo mapInfo)
		{
			if(mapInfo==null) return;
			// clean
			openList.clear();
			closeList.clear();
			// 开始搜索
			openList.add(mapInfo.start);
			moveNodes(mapInfo);
		}
	

		/**
		 * 移动当前结点
		 */
		private void moveNodes(MapInfo mapInfo)
		{
			while (!openList.isEmpty())
			{
				Node current = openList.poll();
				closeList.add(current);
				addNeighborNodeInOpen(mapInfo,current);
				if (isCoordInClose(mapInfo.end.coord))
				{
					drawPath(mapInfo.maps, mapInfo.end);
					break;
				}
			}
		}
		
		/**
		 * 在二维数组中绘制路径
		 */
		private void drawPath(int[][] maps, Node end)
		{
			if(end==null||maps==null) return;
			System.out.println("总代价：" + end.G);
			while (end != null)
			{
				Coord c = end.coord;
				maps[c.y][c.x] = PATH;
				end = end.parent;
			}
		}
	

		/**
		 * 添加所有邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
		{
			int x = current.coord.x;
			int y = current.coord.y;
			// 左
			addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
			// 上
			addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
			// 右
			addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
			// 下
			addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
			// 左上
			addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
			// 右上
			addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
			// 右下
			addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
			// 左下
			addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
		}
	

		/**
		 * 添加一个邻结点到open表
		 */
		private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
		{
			if (canAddNodeToOpen(mapInfo,x, y))
			{
				Node end=mapInfo.end;
				Coord coord = new Coord(x, y);
				int G = current.G + value; // 计算邻结点的G值
				Node child = findNodeInOpen(coord);
				if (child == null)
				{
					int H=calcH(end.coord,coord); // 计算H值
					if(isEndNode(end.coord,coord))
					{
						child=end;
						child.parent=current;
						child.G=G;
						child.H=H;
					}
					else
					{
						child = new Node(coord, current, G, H);
					}
					openList.add(child);
				}
				else if (child.G > G)
				{
					child.G = G;
					child.parent = current;
					openList.add(child);
				}
			}
		}
	

		/**
		 * 从Open列表中查找结点
		 */
		private Node findNodeInOpen(Coord coord)
		{
			if (coord == null || openList.isEmpty()) return null;
			for (Node node : openList)
			{
				if (node.coord.equals(coord))
				{
					return node;
				}
			}
			return null;
		}
	

	

		/**
		 * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
		 */
		private int calcH(Coord end,Coord coord)
		{
			return Math.abs(end.x - coord.x)
					+ Math.abs(end.y - coord.y);
		}
		
		/**
		 * 判断结点是否是最终结点
		 */
		private boolean isEndNode(Coord end,Coord coord)
		{
			return coord != null && end.equals(coord);
		}
	

		/**
		 * 判断结点能否放入Open列表
		 */
		private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
		{
			// 是否在地图中
			if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
			// 判断是否是不可通过的结点
			if (mapInfo.maps[y][x] == BAR) return false;
			// 判断结点是否存在close表
			if (isCoordInClose(x, y)) return false;
	

			return true;
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(Coord coord)
		{
			return coord!=null&&isCoordInClose(coord.x, coord.y);
		}
	

		/**
		 * 判断坐标是否在close表中
		 */
		private boolean isCoordInClose(int x, int y)
		{
			if (closeList.isEmpty()) return false;
			for (Node node : closeList)
			{
				if (node.coord.x == x && node.coord.y == y)
				{
					return true;
				}
			}
			return false;
		}
	}

```
#### DP 顺推模板

``` java
 function DP(): 
    dp = [][] # ⼆维情况 
    for i = 0 .. M { 
        for j = 0 .. N { 
            dp[i][j] = _Function(dp[i’][j’]…) 
        } 
    } 
 return dp[M][N];
```

### 毕业刷题路线

#### 基础

- [两数之和](http://leetcode-cn.com/problems/two-sum)（简单）
- [有效的括号](http://leetcode-cn.com/problems/valid-parentheses/)（简单）
- [字符串解码](http://leetcode-cn.com/problems/decode-string/)（中等）
- [LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache/submissions/)（困难）
- [实现 Trie（前缀树）](http://leetcode-cn.com/problems/implement-trie-prefix-tree/)（中等）
- [添加与搜索单词 - 数据结构设计](http://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)（中等）
- [单词搜索 II ](http://leetcode-cn.com/problems/word-search-ii/)（困难）
- [找不同](http://leetcode-cn.com/problems/find-the-difference/)（简单）
- [单词规律](http://leetcode-cn.com/problems/word-pattern/)（简单）
- [字符串中的第一个唯一字符](http://leetcode-cn.com/problems/first-unique-character-in-a-string)（简单）
- [无重复字符的最长子串](http://leetcode-cn.com/problems/longest-substring-without-repeating-characters)（中等）
- [最小覆盖子串](http://leetcode-cn.com/problems/minimum-window-substring/)（困难）
- [合并两个有序链表](http://leetcode-cn.com/problems/merge-two-sorted-lists)（简单）
- [环形链表](http://leetcode-cn.com/problems/linked-list-cycle)（简单）
- [环形链表 II ](http://leetcode-cn.com/problems/linked-list-cycle-ii)（中等）
- [反转链表](http://leetcode-cn.com/problems/reverse-linked-list)（简单）
- [反转链表 II ](http://leetcode-cn.com/problems/reverse-linked-list-ii)（中等）
- [旋转链表](http://leetcode-cn.com/problems/rotate-list)（中等）
- [排序链表](http://leetcode-cn.com/problems/sort-list/)
- [链表中倒数第 k 个节点](http://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
- [两两交换链表中的节点](http://leetcode-cn.com/problems/swap-nodes-in-pairs)（中等）
- [按奇偶排序数组](http://leetcode-cn.com/problems/sort-array-by-parity/)（简单）
- [按奇偶排序数组 II ](http://leetcode-cn.com/problems/sort-array-by-parity-ii/)（简单）
- [有序数组的平方](http://leetcode-cn.com/problems/squares-of-a-sorted-array/)（简单）
- [山脉数组的峰顶索引](http://leetcode-cn.com/problems/peak-index-in-a-mountain-array)（简单）
- [搜索旋转排序数组](http://leetcode-cn.com/problems/search-in-rotated-sorted-array)（困难）
- [搜索旋转排序数组 II ](http://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)（中等）
- [寻找旋转排序数组中的最小值](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)（中等）
- [寻找旋转排序数组中的最小值 II ](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)（困难）
- [搜索二维矩阵](http://leetcode-cn.com/problems/search-a-2d-matrix)（中等）
- [等式方程的可满足性](http://leetcode-cn.com/problems/satisfiability-of-equality-equations/)（中等）
- [朋友圈](http://leetcode-cn.com/problems/friend-circles/)（中等）
- [账户合并](http://leetcode-cn.com/problems/accounts-merge/)（中等）

#### 深度优先搜索

- [二叉树的最大深度](http://leetcode-cn.com/problems/maximum-depth-of-binary-tree)（简单）
- [路径总和](http://leetcode-cn.com/problems/path-sum/)（简单）
- [路径总和 II ](http://leetcode-cn.com/problems/path-sum-ii/)（中等）
- [被围绕的区域](http://leetcode-cn.com/problems/surrounded-regions/)（中等）
- [岛屿数量](http://leetcode-cn.com/problems/number-of-islands/)（中等）
- [岛屿的最大面积](http://leetcode-cn.com/problems/max-area-of-island/)（中等）
- [在二叉树中分配硬币](http://leetcode-cn.com/problems/distribute-coins-in-binary-tree/)（中等）

#### 回溯

- [括号生成](http://leetcode-cn.com/problems/generate-parentheses/)（中等）
- [N 皇后](http://leetcode-cn.com/problems/n-queens/)（困难）
- [N 皇后 II ](http://leetcode-cn.com/problems/n-queens-ii/)（困难）
- [解数独](http://leetcode-cn.com/problems/sudoku-solver/) （中等）
- [不同路径 III ](http://leetcode-cn.com/problems/unique-paths-iii/)（困难）
- [单词搜索](http://leetcode-cn.com/problems/word-search/)（中等）

#### 分治

- [搜索二维矩阵 II ](http://leetcode-cn.com/problems/search-a-2d-matrix-ii/)（中等）
- [合并 K 个排序链表](http://leetcode-cn.com/problems/merge-k-sorted-lists)（中等）
- [为运算表达式设计优先级](http://leetcode-cn.com/problems/different-ways-to-add-parentheses)（中等）
- [给表达式添加运算符](http://leetcode-cn.com/problems/expression-add-operators)（困难）
- [数组中的第 K 个最大元素](http://leetcode-cn.com/problems/kth-largest-element-in-an-array)（中等）
- [最接近原点的 K 个点](http://leetcode-cn.com/problems/k-closest-points-to-origin/)（中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）

#### 动态规划

- [使用最小花费爬楼梯](http://leetcode-cn.com/problems/min-cost-climbing-stairs)（简单）
- [爬楼梯](http://leetcode-cn.com/problems/climbing-stairs)（简单）
- [不同路径](http://leetcode-cn.com/problems/unique-paths/)（简单）
- [最小路径和](http://leetcode-cn.com/problems/minimum-path-sum/) （中等）
- [最大子序和](http://leetcode-cn.com/problems/maximum-subarray/) （简单）
- [乘积最大子数组](http://leetcode-cn.com/problems/maximum-product-subarray/)（中等）
- [买卖股票的最佳时机](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)（简单）
- [买卖股票的最佳时机 II ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)（简单）
- [买卖股票的最佳时机 III ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)（困难）
- [买卖股票的最佳时机 IV ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)（困难）
- [最佳买卖股票时机含冷冻期](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)（中等）
- [买卖股票的最佳时机含手续费](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)（中等）
- [零钱兑换](http://leetcode-cn.com/problems/coin-change) （中等）
- [零钱兑换 II ](http://leetcode-cn.com/problems/coin-change-2)（中等）
- [编辑距离](http://leetcode-cn.com/problems/edit-distance)（困难）
- [不同的子序列](http://leetcode-cn.com/problems/distinct-subsequences/)（困难）
- [柱状图中最大的矩形](http://leetcode-cn.com/problems/largest-rectangle-in-histogram/)（困难）
- [最大矩形](http://leetcode-cn.com/problems/maximal-rectangle/)（困难）
- [最大正方形](http://leetcode-cn.com/problems/maximal-square/)（中等）
- [最低票价](http://leetcode-cn.com/problems/minimum-cost-for-tickets/)（中等）
- [区域和检索 - 数组不可变](http://leetcode-cn.com/problems/range-sum-query-immutable/)（简单）
- [二维区域和检索 - 矩阵不可变](http://leetcode-cn.com/problems/range-sum-query-2d-immutable/)（中等）
- [最长上升子序列](http://leetcode-cn.com/problems/longest-increasing-subsequence) （中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）
