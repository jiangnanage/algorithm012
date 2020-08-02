### 树  
示例代码： 

		public class TreeNode(){
			public int val;
			public TreeNode left,right;
			public TreeNode(int val){
				this.val = val;
				this.left = null;
				this.right = null;
			}
		}  


- 每个节点都要访问一个
- 每个节点仅访问一次
- 对于节点访问顺序不限
	- 深度优先：depth first search
	- 广度优先：breadth first search
	- 优先级优先

**DFS**  
两个子节点模板  
python

	def dfs(node):
		if node in visited:
			#already visited
			return
		visited.add(node)
		#process current node
		#...# logic here
		dfs(node.left)
		dfs(node.right)  
	
java
	
	void dfs(TreeNode treeNode){
		if (treeNode == null)
  			return null;
		dfs(treeNode.left);
		dfs(treeNode.right);
	}	
多个子节点模板

	visited = set()
	def dfs(node,visited):
		visited.add(node)
		#process current node here
		...
		for next_node in node.children():
			if not next_node in visited:
				dfs(next_node,visited)
非递归模板
	
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
**BFS**
模板  
python

	def bfs(graph,start,end):
		queue = []
		queue.append([start])
		visited.add(start)
		while queue:
			node = queue.pop()
			visited.add(node)
			process(node)
			nodes = generate_related_nodes(node)
			queue.push(nodes)
java  
	
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


### 贪心算法Greedy
贪心算法是一种在每一步选择中都采取在当前状态下的最好或者最优选择，从而希望导致结果是全局最好或最优的算法。  
**贪心算法和动态规划算法区别：**  

- 贪心:当下做局部最优判断，不能回退   
- 回溯：能够回退  
- 动态规划：最优判断+回退  

**适用贪心算法的场景**  

- 问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解；  
- 贪心与动态规划不同在于每个子问题的解决方案都做出选择，不能回退；

**二分查找**  

二分查找的前提  
1. 目标函数单调性  
2. 存在上下界  
3. 能够通过索引访问  

代码模板  


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

