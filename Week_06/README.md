# 动态规划

### 回溯

### 递归  

代码模板

	public void recur(int level,int param){
		//terminator
		if(level > MAX_LEVEL){
			//process result
			return;
		}
		//process current logic
		process(level,param);
		//drill down
		recur(level + 1,newParam);
		//restore current status

	}

  
1. 人肉递归低效，很累  
2. 找到最近最简方法，将其拆解成可重复解决的问题  
3. 数学归纳法思维（抵制人肉递归的诱惑）  
**本质：寻找重复性 ->  计算机指令集**  

### 分治  

代码模板  

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

### 动态规划
Dynamic Programming  
**关键点**  
动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）  
共性：找到重复的子问题  
差异性：最优子结构、中途可以淘汰次优解  

### DP例题解析  
Fibonacci数列
	
	//时间复杂度O(2^n)
	int fib(int n){
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
	
	//时间复杂度O(n)
	int fib(int n){
		int a = new int[n+1];
		a[0] = 1, a[1] = 1;
		for(int i = 0; i <= n; i++){
			a[i] = a[i-1] + a[i-2];
		}
	}

路径计数  

	状态转移方程（dp方程）  
	opt[i,j] = opt[i+1,j] + opt[i,j+1]  
	完整逻辑  
	if a[i,j] = '空地':  
		opt[i,j] = opt[i+1,j] + opt[i,j+1]  
	else:  
		opt[i,j] = 0  

**动态规划关键点**  
1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)  
2. 存储中间状态：opt[i]  
3. 递推公式（美其名曰 状态转移方程或者DP方程）  
	Fib： opt[i] = opt[i-1] + opt[i-2]  
	二维路径:opt[i,j] = opt[i+1,j] + opt[i,j+1]
	(且判断a[i,j]是否为空地)  

**动态规划小结**  
1. 打破自己的思维惯性，形成机器思维  
2. 理解复杂逻辑的关键  
3. 也是职业进阶的要点要领  

# DP例题
- 不同路径（Facebook、亚马逊、微软在半年内面试中考过）
- 不同路径 II （谷歌、美团、微软在半年内面试中考过）
- 最长公共子序列（字节跳动、谷歌、亚马逊在半年内面试中考过）


# 实战题目
- 爬楼梯（阿里巴巴、腾讯、字节跳动在半年内面试常考）
- 三角形最小路径和（亚马逊、苹果、字节跳动在半年内面试考过）
- 三角形最小路径和高票回答： https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up) 
- 最大子序和（亚马逊、字节跳动在半年内面试常考） (DP方程式：f(i) = Max(f(i-1),0)+a[i])
- 乘积最大子数组（亚马逊、字节跳动、谷歌在半年内面试中考过）
- 零钱兑换（亚马逊在半年内面试中常考）
**(DP方程:f(i) = min{f(i-k), for k in [1,2,5]} + 1)**
- [打家劫舍](https://github.com/jiangnanage/algorithm012/blob/master/Week_06/Rob_198.java)（字节跳动、谷歌、亚马逊在半年内面试中考过）
**(DP方程式:f(i) = max(f(i-1),f(i-2) + a[i]))**
- 打家劫舍 II （字节跳动在半年内面试中考过）
- 买卖股票的最佳时机（亚马逊、字节跳动、Facebook 在半年内面试中常考）
- 买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）
- 买卖股票的最佳时机 III （字节跳动在半年内面试中考过）
- 最佳买卖股票时机含冷冻期（谷歌、亚马逊在半年内面试中考过）
- 买卖股票的最佳时机 IV （谷歌、亚马逊、字节跳动在半年内面试中考过）
- 买卖股票的最佳时机含手续费
- 一个方法团灭 6 道股票问题

# 高级 DP 实战题目
- 完全平方数（亚马逊、谷歌在半年内面试中考过）
- 编辑距离 （重点）
- 跳跃游戏（亚马逊在半年内面试中考过）
- 跳跃游戏 II （亚马逊、华为字节跳动在半年内面试中考过）
- 不同路径（Facebook、亚马逊、微软在半年内面试中考过）
- 不同路径 II （谷歌、美团、微软在半年内面试中考过）
- 不同路径 III （谷歌在半年内面试中考过）
- 零钱兑换（亚马逊在半年内面试中常考）
- 零钱兑换 II （亚马逊、字节跳动在半年内面试中考过）

# 本周作业
### 中等
- [最小路径和](https://github.com/jiangnanage/algorithm012/blob/master/Week_06/MinPathSum_64.java)（亚马逊、高盛集团、谷歌在半年内面试中考过）
- [解码方法](https://github.com/jiangnanage/algorithm012/blob/master/Week_06/NumDecodings_91.java)（亚马逊、Facebook、字节跳动在半年内面试中考过）
- [最大正方形](https://github.com/jiangnanage/algorithm012/blob/master/Week_06/MaximalSquare_221.java)（华为、谷歌、字节跳动在半年内面试中考过）
- 任务调度器（Facebook 在半年内面试中常考）
- 回文子串（Facebook、苹果、字节跳动在半年内面试中考过）
### 困难
- 最长有效括号（字节跳动、亚马逊、微软在半年内面试中考过）
- 编辑距离（字节跳动、亚马逊、谷歌在半年内面试中考过）
- 矩形区域不超过 K 的最大数值和（谷歌在半年内面试中考过）
- 青蛙过河（亚马逊、苹果、字节跳动在半年内面试中考过）
- 分割数组的最大值（谷歌、亚马逊、Facebook 在半年内面试中考过）
- 学生出勤记录 II （谷歌在半年内面试中考过）
- 最小覆盖子串（Facebook 在半年内面试中常考）
- 戳气球（亚马逊在半年内面试中考过）
