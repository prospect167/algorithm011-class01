### DFS & BFS
* 每一个节点访问一次
* 每一个节点只访问一次
* 访问的顺序不同分为深度优先搜索（DFS）与（BFS）以及优先级搜索   

**DFS 代码模板**  


	visited = set()    
	def dfs(node, visited):
		if node in visited: # terminator
			return
		
		visited.add(node)

		# process current node here
		
		for next_node in node.children():
			if not next_node in visited:
				dfs(next node, visited)  



**BFS 代码模板**  

	def BFS(graph, start, end):
		visited = set()
		queue = []
		queue.append([start])

		while queue:
			node = queue.pop()
			visited.add(node)

			process(node)
			nodes = generate_related_nodes(node)
			queue.push(nodes)



### 贪心算法 最有利
**定义：** 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。  
**备注：** 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。  
**最佳实践：** 贪心法可以解决最优化问题，如图中最小生成树、哈弗曼编码等等。但是工程和生活的问题，贪心法一般不能得到我们所要的答案（鼠目寸光）。  
即问题能分解成子问题来解决，子问题的的最优解能递推到最终问题的最优解。而其与动态规划的不同在于它对每个子问题解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。  

### 二分查找  
* 目标函数单调性（单调递增或者递减）
* 存在上下界（bounded）  
* 能够通过索引访问（index accessible）  

**模板代码**  

    public int binarySearch(int[] array, int target) {  
	
		int left = 0, right = array.length - 1, mid;
		while(left <= right) {  
			mid = (right - left) / 2 + left;

			if(array[mid] == target) {  
				return mid
			} else if(array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}		

		}
		
		return -1;
	}





