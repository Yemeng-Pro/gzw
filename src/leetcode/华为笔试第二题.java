package leetcode;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-08 23:15
 */
public class 华为笔试第二题 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String[] time=s1.split(",");
        String[] depend=s2.split(",");
        int len=time.length;
        int[] timeRecord=new int[len];
        Deque<Integer> deque=new LinkedList<>();//用来记录任务编号顺序的
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();//存储依赖关系
        for(int i=0;i<len;i++){
            timeRecord[i]=Integer.parseInt(time[i]);
            deque.addLast(i);
        }
        for(int i=0;i<depend.length;i++){
            String cur=depend[i];
            String[] curs=cur.split("->");
            int a=Integer.parseInt(curs[0]);
            int b=Integer.parseInt(curs[1]);
            if(map.containsKey(a)){
                ArrayList<Integer> temp=map.get(a);
                temp.add(b);
                map.put(a,temp);
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(b);
                map.put(a,list);
            }
        }
        int[] res=new int[len];
        int total_time=0;//记录总用时
        while(deque.size()!=0){
            int now=deque.removeFirst();//now是当前任务编号
            if(!map.containsKey(now)){//若不存在依赖，直接运行
                res[now]=total_time+timeRecord[now];
                total_time=total_time+timeRecord[now];
            }else{//若存在依赖，需要判断这些依赖都做完了没
                ArrayList<Integer> needToDoFirst=map.get(now);
                int total_depend=needToDoFirst.size();
                int j=0;
                for(int i=0;i<total_depend;i++){
                    if(res[needToDoFirst.get(i)]==0){
                        deque.addLast(now);//去对尾排队
                        break;
                    }
                    j++;
                }
                if(j==total_depend){//说明依赖的任务都已经走过了
                    res[now]=total_time+timeRecord[now];
                    total_time=total_time+timeRecord[now];
                }
            }
        }
        for(int k=0;k<len;k++){
            if(k<(len-1)){
                System.out.print(res[k]+",");
            }else{
                System.out.print(res[k]);
            }
        }
    }
}
