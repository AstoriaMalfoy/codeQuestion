#题目背景
初一党应该都知道......

#题目描述
话说有一天 linyorson 在“我的世界”开了一个n×n（n≤100）的方阵，现在他有 m 个火把和 k 个萤石，分别放在 (x1 ,y1)∼(xm,ym) 和  (o1,p1)∼(ok,pk) 的位置，没有光或没放东西的地方会生成怪物。请问在这个方阵中有几个点会生成怪物？

P.S. 火把的照亮范围是：

    |暗|暗| 光 |暗|暗|
    |暗|光| 光 |光|暗|
    |光|光|火把|光|光|
    |暗|光| 光 |光|暗|
    |暗|暗| 光 |暗|暗|
萤石：

    |光|光| 光 |光|光|
    |光|光| 光 |光|光|
    |光|光|萤石|光|光|
    |光|光| 光 |光|光|
    |光|光| 光 |光|光|
#输入格式
输入共 m+k+1 行。

第一行为 n,m,k。

第 2 到第 m+1 行分别是火把的位置 xi,yi。

第 m+2 到第 m+k+1 行分别是萤石的位置 oi,pi。

注：可能没有萤石，但一定有火把。

所有数据保证在 int 范围内。

#输出格式
有几个点会生出怪物。

#输入输出样例
##输入
5 1 0
3 3
##输出
12