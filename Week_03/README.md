# 第三周学习笔记

## 递归（Recursion）
递归 - 循环

通过函数体来进行的循环

树的面试题解法一般都是递归 
原因：
1. 节点的定义
2. 重复性（自相似性）

### 递归模板
1. 递归终止条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层
```java
public void recur(int level, int param) { 
  // terminator 递归终止条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 处理当前层逻辑
  process(level, param); 
  // drill down 下探到下一层
  recur( level: level + 1, newParam); 
  // restore current status 清理当前层
}
```
### 思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

### 递归与尾递归
#### 1. 递归
简单的来说递归就是一个函数直接或间接地调用自身，是为直接或间接递归。一般来说，递归需要有边界条件、递归前进段和递归返回段。当边界条件不满足时，递归前进；当边界条件满足时，递归返回。
用递归需要注意以下两点：

    1. 递归就是在过程或函数里调用自身
    2. 在使用递归策略时，必须有一个明确的递归结束条件，称为递归出口
    
递归一般用于解决三类问题：

    1. 数据的定义是按递归定义的。（Fibonacci函数，n的阶乘）
    2. 问题解法按递归实现。（回溯）
    3. 数据的结构形式是按递归定义的。（二叉树的遍历，图的搜索）

递归的缺点：

递归解题相对常用的算法如普通循环等，运行效率较低。在递归调用的过程当中系统为每一层的返回点、局部量等开辟了栈来存储，因此递归次数过多容易造成栈溢出。

#### 2. 尾递归
尾递归就是把当前的运算结果（或路径）放在参数里传给下层函数，深层函数所面对的不是越来越简单的问题，而是越来越复杂的问题，因为参数里带有前面若干步的运算路径。

尾递归的判断标准是函数运行最后一步是否调用自身，而不是是否在函数的最后一行调用自身

特点：
尾递归在普通尾调用的基础上，多出了2个特征：
    
   1. 在尾部调用的是函数自身 (Self-called)；
   2. 可通过优化，使得计算仅占用常量栈空间 (Stack Space)。


这是尾递归：
```java
function f(x) {
   if (x === 1) return 1;
   return f(x-1);
}
```
这不是尾递归：
```java
function f(x) {
   if (x === 1) return 1;
   return 1 + f(x-1);
}
```

## 回溯法 

采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

- 找到一个可能存在的正确的答案；
- 在尝试了所有可能的分步方法后宣告该问题没有答案。
 
## 深度优先搜索（Depth-First-Search，DFS）

是一种用于遍历或搜索树或图的算法。这个算法会 尽可能深 的搜索树的分支。当结点 v 的所在边都己被探寻过，搜索将 回溯 到发现结点 v 的那条边的起始结点。这一过程一直进行到已发现从源结点可达的所有结点为止。如果还存在未被发现的结点，则选择其中一个作为源结点并重复以上过程，整个进程反复进行直到所有结点都被访问为止。

理解：
  
    「回溯算法」与「深度优先遍历」都有「不撞南墙不回头」的意思。我个人的理解是：
        「回溯算法」强调了「深度优先遍历」思想的用途，用一个 不断变化 的变量，
        在尝试各种可能的过程中，搜索需要的结果。强调了 回退 操作对于搜索的合理性。
        而「深度优先遍历」强调一种遍历的思想，与之对应的遍历思想是「广度优先遍历」

### 与动态规划的区别

#### 共同点：
用于求解多阶段决策问题。多阶段决策问题即：

- 求解一个问题分为很多步骤（阶段）；
- 每一个步骤（阶段）可以有多种选择。
#### 不同点
- 动态规划只需要求我们评估最优解是多少，最优解对应的具体解是什么并不要求。因此很适合应用于评估一个方案的效果；
- 回溯算法可以搜索得到所有的方案（当然包括最优解），但是本质上它是一种遍历算法，时间复杂度很高。

### 理解回溯
从 [1, 2, 3] 到 [1, 3, 2] ，深度优先遍历是这样做的，从 [1, 2, 3] 回到 [1, 2] 的时候，需要撤销刚刚已经选择的数 3，因为在这一层只有一个数 3 我们已经尝试过了，因此程序回到上一层，需要撤销对 2 的选择，好让后面的程序知道，选择 3 了以后还能够选择 2。

执行深度优先遍历，从较深层的结点返回到较浅层结点的时候，需要做「状态重置」，即「回到过去」、「恢复现场」

## 回溯经典题目，排列，组合，子集
### 什么时候使用 used 数组，什么时候使用 begin 变量
简单总结一下：

- 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
- 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
- 子集问题，当前层可选可不远，算是组合问题，从当前层选择空，或者选择当前层数字即可

## 分治思想

和递归差不多，区别是需要处理当前层逻辑后，需要归并分治的结果

## 八皇后问题

看似挺难的一道题，分解后也不是很难

首先分析题目，横，竖，左斜，右斜都不能遇到Q，其实就是当前列表能放的需要判断是否合法
1. 递归终结者
    
    - 到达第n层就结束
2. 处理当前层
    
    - 从0-n循环列
    - 判断当前行列是否合法，不合法跳过当前层
    - 将当前行列置为Q
3. 进入下一层
4. 不要忘记将当前行列置为 . 清除状态

> 判断是否合法：
>1. 先判断上方是否有Q
>2. 判断左上方是否有Q
>3. 判断右上方是否有Q
    
实现逻辑如下：
```java
public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append('.');
        for (int i = 0; i < n; ++i) list.add(sb.toString());
        return doSolveNQueens(n,result,list,0);
    }

    private List<List<String>> doSolveNQueens(int n, List<List<String>> result, ArrayList<String> list, int row) {
        if (row == n){
            result.add(new ArrayList<>(list));
            return result;
        }
        for (int col = 0; col < n; col++) {
            // 因为每次添加完Q后，直接进入下一层，所以同层只有一个Q
            if (!isValidQueens(row,list,col,n)) continue;
            // 将当前行列置为Q
            setChar(row,col,'Q',list);
            // 到下一行
            doSolveNQueens(n,result,list,row + 1);
            // 清理当前层状态，改成 .
            setChar(row,col,'.',list);
        }
        return result;
    }

    private boolean isValidQueens(int row, ArrayList<String> list, int col,int n) {
        // 判断上方是否有Q
        for (int i = 0; i < row; ++i) {
            if (list.get(i).charAt(col) == 'Q')
                return false;
        }
        // 判断左上方是否有Q
        for (int i = row - 1,j = col - 1;i >= 0 && j >= 0;--i,--j) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
        }
        // 判断右上方是否有Q
        for (int i = row - 1,j = col + 1;i >= 0 && j < n; --i,++j) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    private void setChar(int row, int col, char c,ArrayList<String> list) {
        StringBuilder sb = new StringBuilder(list.get(row));
        sb.setCharAt(col, c);
        list.set(row, sb.toString());
    }
```