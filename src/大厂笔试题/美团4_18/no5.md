排火车
时间限制： 3000MS
内存限制： 786432KB
题目描述：
排火车是一种常见的扑克游戏。两位玩家手持均分数量的扑克牌，每一轮玩家按照如下步骤操作：

1. 只能出自己手中牌堆最上方的一张牌，两位玩家会将出的牌按顺序在桌面上排成一列。

2. 如果出的牌与桌面上的某张牌数字相同，则可以取走这两张牌与夹在这两张牌中间的所有牌，按照出牌的顺序依次插入手中牌堆的末尾。取牌后该玩家需要再次出牌，并且判断桌面上是否有数字相同的牌；否则该轮结束，轮到对方出牌。

假设小美（Mei）是先手，小团（Tuan）是后手，最终牌堆中牌数量较多者获胜。若游戏进行n次（一次：指当前玩家不断出牌的这一次，下一次指更换到对手出牌），哪一方是胜者？若n次内某一方的牌出完了，则该方直接失败。若双方牌堆中牌数量相同，则为平局（Draw）。

扑克牌的类型有A，2，3，4，5，6，7，8，9，10，J，Q，K，Joker。

扑克牌共有54张（Joker2张，其他类型的牌有4张）

数据范围：1≤T≤20，1≤n≤200000



输入描述
第一行输入一个整数T，表示测试用例的数量。

对于每组测试用例

第1行按顺序输入27张牌，用空格隔开，依次表示小美牌堆从上到下的牌。

第2行按顺序输入27张牌，用空格隔开，依次表示小团牌堆从上到下的牌。

保证输入的所有牌是A，2，3，4，5，6，7，8，9，10，J，Q，K，Joker中的一个，且54张牌是合法的一副扑克（A，2，3，4，5，6，7，8，9，10，J，Q，K各出现4次，Joker各出现2次）。

第3行输入一个整数n，表示游戏进行的轮数。

输出描述
共T行，对于每组数据，输出一行字符串：若先手获胜则输出Mei，若后手获胜则输出Tuan，若平局则输出Draw。


样例输入
5
4 A 3 K A 7 10 8 8 Q 5 Q 9 J 6 K 7 J K 5 3 Q 6 9 8 2 2
3 2 2 A Joker J 9 K 10 7 A J 5 10 10 4 4 7 4 Joker 5 6 Q 3 9 6 8
1
4 A 3 K A 7 10 8 8 Q 5 Q 9 J 6 K 7 J K 5 3 Q 6 9 8 2 2
3 2 2 A Joker J 9 K 10 7 A J 5 10 10 4 4 7 4 Joker 5 6 Q 3 9 6 8
2
4 A 3 K A 7 10 8 8 Q 5 Q 9 J 6 K 7 J K 5 3 Q 6 9 8 2 2
3 2 2 A Joker J 9 K 10 7 A J 5 10 10 4 4 7 4 Joker 5 6 Q 3 9 6 8
3
4 A 3 K A 7 10 8 8 Q 5 Q 9 J 6 K 7 J K 5 3 Q 6 9 8 2 2
3 2 2 A Joker J 9 K 10 7 A J 5 10 10 4 4 7 4 Joker 5 6 Q 3 9 6 8
4
4 A 3 K A 7 10 8 8 Q 5 Q 9 J 6 K 7 J K 5 3 Q 6 9 8 2 2
3 2 2 A Joker J 9 K 10 7 A J 5 10 10 4 4 7 4 Joker 5 6 Q 3 9 6 8
5
样例输出
Tuan
Draw
Tuan
Draw
Mei
