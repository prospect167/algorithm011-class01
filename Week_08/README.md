### 位运算  
#### 为什么需要位运算？ 
  机器里的数字表示方式和存储格式就是二进制。  

#### 位运算符   
* 左移
* 右移  


### 布隆过滤器
* bloom filter vs hashMap  
	一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。  
	优点：空间效率和查询时间都远远超过一般的算法  
	缺点：有一定的误识别率和删除困难  
	最佳实践：放在最外层做过滤，缓存查询  
	案例：比特币网络、分布式系统（Map-Reduce)、Redis缓存、垃圾邮件或评论等的过滤  


### LRU Cache  
* Cache 缓存
* 两个要素：大小、替换策略
* HashTable + DoubleLinkedList  
* O(1) 查询， O(1)新增和更改  


### 排序算法
* 分类  
 	比较类排序  
  
  * 交换排序
  * 插入排序
  * 选择排序
  * 归并排序

  	非比较类排序  

  * 计数排序
  * 桶排序
  * 基数排序  

* 初级排序[O(n^2)]  
	1、选择排序  
		每次找最小值，然后放到待排序数组的起始位置  
	2、插入排序    
		从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入  
	3、冒泡排序  
		嵌套循环，每次查看相邻的元素如果逆序，则交换  

* 高级排序[O(n*Logn) ]  
	1、快速排序 -- 分治思想   
		数组取标杆 pivot,将小元素放在 pivot 左边，大元素放右侧，然后依次对左边和右边的子数组继续快排；以达到整个序列有序 
 
	2、归并排序 -- 分治思想  
		首先，把长度为 n 的输入序列分成两个长度为 n/2 的序列  
		其次，对这两个子序列分别采用归并排序  
		最后，将两个排序好的子序列合并成一个最终的排序序列

	总结：快排 和 归并 具有相似性，但步骤相反；  
	其中，归并是 先排序左右子数组，然后合并两个有序子数组；   
	而快排是 先调配出左右子数组，然后对于左右子数组进行排序  

	3、堆排序  -- 堆插入O(logN), 取最大/最小值O(1)  
		
* 特殊排序[O(n)]  
	1、计数排序(Counting sort)  
		计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1的填充回原数组  

	2、桶排序(Bucket Sort)  
		桶排序的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）  

	3、基数排序(Radix sort)  
		基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级的，先按低优先级排序，再按高优先级排序。