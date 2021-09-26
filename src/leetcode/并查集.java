package leetcode;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shkstart
 * @create 2021-04-08 15:09
 */
public class 并查集 {
    final int  N=1005;				//指定并查集所能包含元素的个数（由题意决定）
    int[] pre = new int[N];     					//存储每个结点的前驱结点
    int[] rank = new int[N];    					//树的高度


    void init(int n)     				//初始化函数，对录入的 n个结点进行初始化
    {
        for(int i = 0; i < n; i++){
            pre[i] = i;     			//每个结点的上级都是自己
            rank[i] = 1;    			//每个结点构成的树的高度为 1
        }
    }
    int find(int x)     	 		    //查找结点 x的根结点
    {
        if(pre[x] == x) return x;  		//递归出口：x的上级为 x本身，则 x为根结点
        return find(pre[x]); 			//递归查找
    }


//    int find(int x)     				//改进查找算法：完成路径压缩，将 x的上级直接变为根结点，那么树的高度就会大大降低
//    {
//        if(pre[x] == x) return x;		//递归出口：x的上级为 x本身，即 x为根结点
//        return pre[x] = find(pre[x]);   //此代码相当于先找到根结点 rootx，然后 pre[x]=rootx
//    }

    private boolean isSame(int x, int y) {    		//判断两个结点是否连通
        return find(x) == find(y);  	//判断两个结点的根结点（即代表元）是否相同
    }

    boolean join(int x,int y)
    {
        x = find(x);						//寻找 x的代表元
        y = find(y);						//寻找 y的代表元
        if(x == y) return false;			//如果 x和 y的代表元一致，说明他们共属同一集合，则不需要合并，返回 false，表示合并失败；否则，执行下面的逻辑
        if(rank[x] > rank[y]) pre[y]=x;		//如果 x的高度大于 y，则令 y的上级为 x
        else								//否则
        {
            if(rank[x]==rank[y]) rank[y]++;	//如果 x的高度和 y的高度相同，则令 y的高度加1
            pre[x]=y;						//让 x的上级为 y
        }
        return true;						//返回 true，表示合并成功
    }


    @Test
    public void test() throws IOException {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//        System.out.println(removeStones(stones));
//        Scanner input = new Scanner(System.in);
//        String a = input.nextLine();
//        int b = input.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");


    }

    public int removeStones(int[][] stones) {
        int sum = 0;
        int n = stones.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        //初始化
        for(int i = 0;i<stones.length;i++){
            parent[i] = i;
            rank[i]  = 1;
        }
        //查询合并
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if((stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) && find(parent,i) != find(parent,j)){
                    union(parent,rank,i,j);
                    sum++;
                }
            }

        }
        return sum;
    }

    private void union(int[] parent,int[] rank,int x, int y){
        int fx = find(parent,x);
        int fy = find(parent,y);
        if(fx == fy){
            return;
        }
        if(rank[fx]>=rank[fy]){
            parent[fy] = fx;
            rank[fx] += rank[fy];
        }else{
            parent[fx] = fy;
            rank[fy] += rank[fx];
        }
    }

    private int find(int[] parent,int x){
        if(parent[x]==x) return x;
        parent[x] = find(parent,parent[x]);
        return parent[x];
    }

}
