如果把你放进迷宫，你该怎么走出来？一个比较稳妥地做法是试探法，简单来说就是试探某条路可否到达出口，不可以的话换另一条路。

具体来说就是每次遇到岔口，选择一个没有探索过的方向前进，当最终发现这个方向是条死路时，就回到这个岔口，选择另一个没有探索过的方向试探，如果这个路口所有方向都是死路，就回退到上一个路口继续尝试。最终会走出迷宫，或者回到入口（这时候迷宫本来就没有出口）。

下面给出一副图来方便我们更好地理解走迷宫的稳妥做法：

![][1]

小松鼠在岔口 A 选择向上走，很快就发现这是死路，于是回退到 A 点将向上的方向标记为“不可达”，选择向右走。很快，就会遇到 B 岔口，选择向右左，于是再次陷入死路，回退到 B 将右方向标记为 “不可达” 继续向左走。接着，它可能会遇到 C，D 等一系列岔口，做出一系列选择，标记一系列 “不可达”，回退一系列路口做出新的选择，不过幸运的是它最终一定会找到图中所示的绿色大道。

细细品味这个过程，它就是“回溯法”的精华所在！

# 回溯：回头是岸

## 抽象：万法归一

我们将上述走迷宫策略进行`抽象化`，来适应更普遍的情况。

首先对问题的状态进行抽象化。将问题的初始状态看作是一个树的根部，针对初始状态，可能有很多可能的解法，每个解法对应树的一个分岔，使用该解法得到的新的问题状态对应根结点的孩子结点。对每个新的问题状态，又有很多可能的解，所以会继续形成分叉，生成新的问题状态（子结点）。

依次递归下去，直到问题的一个状态不存在任何可能的解法时，将此状态记为叶子结点，同时标记为“不可达”。当问题的一个状态就是初始问题的一个解法时，也将其记为叶子结点，同时标记为“可行解”（可能有多个可行解）。所以，树的中间结点代表了所求解问题的一个中间状态，叶子结点代表找到了问题的解或者达到绝境。这里抽象出来的树一般称为`解空间状态树`，如下所示：

![][2]

树的每一条边代表一次“选择”。即针对父结点代表的问题状态，给出的一种解决方法，通过这个解决方法，达到了子结点所代表的问题状态。每次从父结点到子结点，我们都更加靠近最终答案或者最后绝境。由根结点到可行解叶子结点的路径则确定了这个问题的一个解法。 
## 回溯：以退为进

针对上述的解空间状态树，如何去找到可行解呢？很简单，用走迷宫的方法。

从根结点开始，任意选择一条边往下走，每当遇到一个结点，有以下几种可能：

1. 该结点是不可达叶结点（如图中1），那么回退到它的父亲结点，选择没有走过的边往下走；
2. 该结点是中间结点，它所有子路径都已经走过，且没有找到问题的解（如图中2），那么回退到其父结点，选择没有走过的边往下走；
3. 找到一个可行解（如图中3），可以选择终止搜索，或者继续回退找其余的解。
4. 如果结点是父结点，且所有子路径都已经走过，且没有找到问题的解，那么该问题无解。

以上就是回溯的整个算法思想，图示如下：

![][3]

回溯算法实际上是一个类似枚举的搜索尝试过程，在搜索过程中寻找问题的解，当发现当前问题状态无解时，就“回溯”返回，尝试别的路径。许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。

# 实现：程序的细节

回溯的思想大概很简单，但是实现起来有以下几点需要思考的地方：

* 怎样去保存一个结点，即如何去定义问题状态；
* 如何判断当前结点解的可能性：是中间结点，还是叶子结点（可行解或者不可达）；
* 如何保存根结点到叶子结点的路径；
* 如何回退到父结点。

针对不同的问题场景，上面的问题有不同的解决办法，无法一一给出。不过我们可以抽象地给出所有问题的一般解过程，下面为其递归实现（保存所有的解）：

    void backtrack(state s) {
        if(s is end){           // 当前结点为可行解
            sols.append(path);  // 保存该解
        }
        else if(s has no ways){ // 当前结点为不可达叶子结点
            return; 
        }
        else{                   // 当前结点为中间结点
            for(i in possible ways){
                next_s = do i in s; // 选择一条边
                backtrack(next_s);  // 在选择的边上往下走
                s = redo i in s;    // 回溯到父结点
            }
        }
    }

# 例子：更好的理解

39 Combination Sum

## [N 皇后](https://leetcode.com/problems/n-queens/)

很多人都知道 `8皇后问题`，即在8X8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上。一种可能的放置方法法如下：

![][4]

现在，将此问题扩展为有 N 个皇后，放在 N*N 的格子里，求一共有多少种方法。


# 参考  
[Wikipedia: Backtracking](https://en.wikipedia.org/wiki/Backtracking)  


[1]: ../Images/Backtracking_1.png
[2]: ../Images/Backtracking_2.png
[3]: ../Images/Backtracking_3.png
[4]: ../Images/Backtracking_4.png

