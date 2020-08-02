### 动态规划（动态递推）  
动态规划 和 递归 以及分治 没有根本上的区别（关键看有无最优的子结构） 

* 递归代码模板  
	
		public void recurision(int level, int param) {
			// terminator
			if ( level > MAX_LEVEL) {
				return;
			}  
		
			// process current logic
			process(level, param);
		
			// drill down
			recrivision(level+1, newParam);
			
			// restore
     		
		}  

* 分治  
 1、终止条件  
 2、划分子问题  
 3、子问题继续递归  
 4、合并子问题得到最终解

* 动态规划解题三步骤

		分治（最优子结构） opt[n] = best_of(opt[n-1],opt[n-2]……)  
		存储中间状态：opt[i]  
		递推公式（状态转移方程 or DP 方程）

 **总结**：  

* 人肉递归低效   
* 寻找重复子问题 
* 数学归纳法思维 
* 打破思维惯性，形成机器思维（最优子结构） 
  


		
