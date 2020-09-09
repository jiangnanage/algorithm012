# 字典树(Trie树)  
### 字典树的数据结构
又称单词查找树或者键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。  
它的有点是：最大限度地减少无谓的字符串比较，查询效率比哈希高。   

### 字典树的核心思想
空间换时间；  
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的；
### 字典树的基本性质
1. 结点本身不存完整单词
2. 从根节点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同；

### Trie 树模板

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


# 并查集 Disjoint Set

### 适用场景
- 组团、配对问题  
- Group or not？  

### 基本操作
- makeSet(s):建立一个新的并查集，其中包含s个单元素集合。  
- unionSet(x,y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。  
- find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。 （路径压缩） 

### 并查集模板
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


# 高级搜索
### 剪枝

### 双向BFS


### 启发式搜索 Heuristic Search（A*）
基于BFS  
估价函数  
启发式函数：h(n),它用来评价哪些结点最有希望的是一个我们要找的结点，h(n)会返回一个非负数，也可以认为是从结点n的目标结点路径的估计成本。
启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。  

A* python代码模板

	# Python
	def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
   		unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)  

  
A* java代码模板 

	//Java
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

shortest Path
1.BFS经典的BFS代码
2.A*search 
	估价函数：h(current_point) = dist(current_point,destination_point)

### 初级搜索
1. 朴素搜索
2. 优化方式：不重复(fibonacci)、剪枝(生成括号问题)
3. 搜索方向： DFS深度优先搜索 BFS广度优先搜索  双向搜索、启发式搜索  

# AVL树和红黑树 

### 保证性能的关键
1. 保证二维维度！ -> 左右子树结点平衡（recursively）
2. Balanced [平衡二叉树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)
### AVL树
1. 发明者 G.M.Adelson-Velsky 和 Evgenii Landis  
2. Balance Factor （平衡因子）:是它的左子树的高度减去它的右子树的高度(有时相反)。balance factor = {-1,0,1}  
3. 通过旋转操作来进行平衡(四种: 左旋|右旋|左右旋|右左旋)   
子树状态 右右子树 -> 左旋  
子树状态 左左子树 -> 右旋  
子树状态 左右子树 -> 左右旋  
子树状态 右左子树 -> 右左旋  
### AVL总结
1. 平衡二叉搜索树  
2. 每个结点存 balance factor={-1,0,1}  
3. 四种旋转操作  
不足：结点需要存储额外信息、且调整次数频繁  
### 红黑树 Red-black Tree  
红黑树是一种近似平衡的二叉搜索树(Binary Search Tree),它能够确保任何一个结点的左右子树的**高度差小于两倍**。具体来说，红黑树是满足如下条件的二叉搜索树：  
- 每个结点要么是红色，要么是黑色  
- 根结点是黑色  
- 每个叶结点（NIL结点、空结点）是黑色  
- 不能有相邻接的两个红色结点  
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点  

AVL树提供更快的查询操作，红黑树提供更快的增加和删除操作  
AVL需要存储额外信息（factor和heights），红黑树只需存储一个bit来存0和1表示黑或者红
红黑树多用于language libraries,AVL多用于databases
