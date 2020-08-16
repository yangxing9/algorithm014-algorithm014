## 第一周学习笔记
1. 学习习惯问题
    - 不要死磕
    - 五毒神掌（主要是反复练习做过的题目）
    - 看高票解答，高质量讲解
2. 切题四件套
    - Clarification
    - Possible solutions
        - compare (time/space)
        - optimal（加强）
    - Coding（多写）
    - Test cases
3. 五毒神掌
    1. 第一遍
        - 5分钟：读题 + 思考
        - 直接看解法：注意！多解法，比较解法优劣
        - 背诵、默写好的解法
    2. 第二遍
        - 马上自己写 —> LeetCode 提交
        - 多种解法比较、体会 —> 优化！
    3. 第三遍
        - 过了一天后，再重复做题
        - 不同解法的熟练程度 —> 专项练习
    4. 第四遍
        - 过了一周：反复回来练习相同题目
    5. 第五遍
        - 面试前一周恢复性训练
        
### 复杂度总结
1. 时间复杂度
```
    O(1): Constant Complexity 常数复杂度
    O(log n): Logarithmic Complexity 对数复杂度
    O(n): Linear Complexity 线性时间复杂度
    O(n^2): N square Complexity 平方
    O(n^3): N cubic Complexity 立方
    O(2^n): Exponential Growth 指数
    O(n!): Factorial 阶乘
    注意：只看最高复杂度的运算
```
2. 空间复杂度
```
1. 数组的长度
2. 递归的深度（特殊说明）
```
### 数据结构
1. 一维：
   - 基础：数组、链表
   - 高级：栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc
2. 二维：
   - 基础：树、图
   - 高级：二叉搜索树 binary search tree (red-black tree, AVL), 堆 heap, 并查集 disjoint set, 字典树 Trie, etc
3. 特殊：
    - 位运算 Bitwise, 布隆过滤器 BloomFilter
    - LRU Cache

#### 跳表
特点：
> 注意：只能用于元素有序的情况。
  跳表（skip list）对标的是平衡树（AVL Tree）和二分查找，
  是一种 插入/删除/搜索 都是 O(log n) 的数据结构。1989 年出现。
  它最大的优势是原理简单、容易实现、方便扩展、效率更高。因此
  在一些热门的项目里用来替代平衡树，如 Redis、LevelDB 等

其实现主要是通过 升维思想 + 空间换时间

#### 栈与队列
特点：
> - Stack：先入后出；添加、删除皆为 O(1)
> - Queue：先入先出；添加、删除皆为 O(1)

##### Deque 
    1. 简单理解：两端可以进出的 Queue
        Deque - double ended queue 
    2.插入和删除都是 O(1) 操作

##### 优先队列 Priority Queue
    1. 插入操作：O(1)
    2.取出操作：O(logN) - 按照元素的优先级取出
    3.底层具体实现的数据结构较为多样和复杂：heap、bst、treap

使用栈的算法总结：

    如果一个问题具有最近相关性，那么可以用栈解决，同时有些问题可以考虑使用两个栈实现，单调栈实现

使用链表的算法总结：

    可以考虑递归实现，递归的时候需要考虑返回的值，有些链表反转的问题需要引入一个头结点
    判断链表是否有环等相关问题可以使用快慢指针实现

使用指针的总结：
    
    一般如果需要求最大面积，等需要两个维度综合的可以使用夹逼法，夹逼法又可以使用双指针实现
   