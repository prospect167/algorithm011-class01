### 概念  
哈希表：根据关键码值（key）直接进行访问的数据结构（亦称为散列表）。  
	其通过关键码值映射到表中一个位置来访问记录，以加快查找的速度。  
	其中映射函数称为散列函数，存放记录的数组称为哈希表。  
	哈希碰撞（减少哈希碰撞，设计优秀的散列函数，java 的 hashcode）   
**search、insert、delete 的时间复杂度都是O(1)**（正常情况下）   
可以理解数组是一种的特殊哈希表，不过数组的关键码值是数组下标，而哈希表的关键码值兼容各种值，需要经过散列函数转换成数组（哈希表）的下标；或者说哈希表是模拟数组设计出来的，本身也是如此，java 中的 HashMap 就是基于 数组 + 链表 + 红黑树实现的（JDK1.8）。  

### 设计  
* 首先 JAVA 中的 HashMap 是工业级的设计，综合考虑了时间和空间复杂度。
* put 元素的时候，遇到哈希碰撞时，HashMap 采用的是链地址法，即数组 + 链表的结构，也就是说每一个数组元素其实是一个链表结构，考虑到如果在极端情况，一直哈希碰撞，则整体的数据结构转换成为一条链表，此时的查询时间复杂度为O(n)，故在 java8 中引入了红黑树，即当链表长度`>=8`时，转换为红黑树，此时的查询时间复杂度O(logn)  
* get 元素的时候，逻辑跟 put 刚好相反。  

### 源码  
	public V put(K key, V value) {  
	 	// 对 key 的 hashCode() 做 hash  
	 	return putVal(hash(key), key, value, false, true);  
	}  
	final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {  
		Node<K,V>[] tab; Node<K,V> p; int n, i;  
		// 步骤1：tab为空则创建
	    if ((tab = table) == null || (n = tab.length) == 0)  
			n = (tab = resize()).length;
	    // 步骤2：计算 index，并对 null 做处理  
		if ((p = tab[i = (n - 1) & hash]) == null) 
	         tab[i] = newNode(hash, key, value, null); 
		else {
	         Node<K,V> e; K k;
	         // 步骤3：节点 key 存在，直接覆盖 value
	         if (p.hash == hash &&
	             ((k = p.key) == key || (key != null && key.equals(k))))
	             e = p;
	         // 步骤4：判断该链为红黑树  
	         else if (p instanceof TreeNode)
	             e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
	         // 步骤5：该链为链表  
		     else {
	             for (int binCount = 0; ; ++binCount) {
	                if ((e = p.next) == null) {
	                     p.next = newNode(hash, key,value,null);
                         // 链表长度大于 8 转换为红黑树进行处理
	                     if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st  
	                        treeifyBin(tab, hash);
	                     break;
	                }
                    // key已经存在直接覆盖value
	                if (e.hash == hash &&((k = e.key) == key || (key != null && 	key.equals(k)))) 
						break;
	                p = e;
	             }
	         }
		}  
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
               e.value = value;
	        afterNodeAccess(e);
            return oldValue;
        }
	 }
	 ++modCount;
	 // 步骤6：超过最大容量 就扩容
	 if (++size > threshold)
       resize();
	   afterNodeInsertion(evict);
	   return null;
    }
		