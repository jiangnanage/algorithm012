# 高级动态规划

## 递归、分治、回溯、动态规划复习

### 递归

#### 代码模板

```java
public void recur(int level, int param) {
  
	// terminator 
	if (level > MAX_LEVEL) {
		// process result
		return; 
  }
	// process current logic 
  process(level, param);
	// drill down 
  recur(level: level + 1, newParam);
	// restore current status
}
```

### 分而治之

#### 代码模板

```python
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator 
  if problem is None:
  	print_result 
    return
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data)
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  …
  
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
  # revert the current level states
```

本质：寻找重复性 —> 计算机指令集

**DP 顺推模板**

```
 function DP(): 
    dp = [][] # ⼆维情况 
    for i = 0 .. M { 
        for j = 0 .. N { 
            dp[i][j] = _Function(dp[i’][j’]…) 
        } 
    } 
 return dp[M][N];
```
**关键点**

动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）

拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

**不同路径2的状态转移方程式** 

用dp(i, j) 来表示从坐标 (i, j) 的路径总和，f(i, j) 表示是否有障碍物  
如果 f(i, j) = 0 表示没有障碍物，**dp(i, j) = dp(i-1, j) + dp(i, j-1)**  
f(1, j) = 1 表示有障碍物，**dp(i, j) = 0**; 

#### 字符串

**遍历**
```
// Java
 Stirng x= "abcd";
 for (int i=0; i<x.size(); i++) {
     char ch = x.charAt(i);
     System.out.print(ch);
 }
```
**比较**
```
// Java
Stirng x= new String("abcd");
Stirng y= new String("abcd");
x==y //false
x.equals(y) // true
x.equalsIgnoreCase(y) //true
```

**字符串匹配算法**
1. 暴力法
2. Rabin-Karp算法
3. KMP算法
