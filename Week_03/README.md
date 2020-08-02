### 递归代码模板
~~~
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
~~~

### 思维要点：
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

分治、回溯  特殊的递归  
本质就是要找重复性  
最优重复性：动态规划  
最近重复性：分治/回溯  
