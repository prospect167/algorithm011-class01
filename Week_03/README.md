### 递归  
1、递归的本质是重复性（自相似性），故好多问题都是寻找题目设定条件的最小重复性；所以解决递归的关键点就是如何寻找重复性？  
2、建议：不要人肉递归（想不明白，会整糊涂自身），可通过画图进行数学归纳找重复性。  
3、递归模板代码  
  
	public void recur(int level, int param) {
		// terminator  
		if (level > MAX_LEVEL) {
			return;
		}
		
		// process current logic  
		process(level, param);
	
		// drill down  
		recur(level + 1, newParam);
	
		// restore current status
	}  

### 分治 & 回溯  
1、分治 & 回溯 是一种特殊的递归  
2、分治是将大问题分解为小问题递归求解，然后合并结果集（最小重复性）  
3、回溯主要通过不断试错去尝试分步解决问题，如果在解决问题过程中发现分步答案不能解决问题，则取消上一步或者几步的计算。（回溯 + 剪枝）
