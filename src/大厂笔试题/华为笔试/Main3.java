package 大厂笔试题.华为笔试;

/**
 * @author shkstart
 * @create 2021-04-26 21:19
 */
public class Main3 {
//    #include<bits/stdc++.h>
//    using namespace std;
//
//    vector<int> uploadSpeeds(vector<int>& speed){
//        vector<int> ret;
//        int len = speed.size();
//
//        int lastAEB = -1; //prevent repeating report
//        int timer = 1; //normal timer
//        int curAEB = 0; //the timer for AEB
//        bool AEB = false; //is current AEB
//        ret.push_back(speed[0]);
//        for(int i=1;i<len;i++)
//        {
//            //在AEB状态下，单独处理
//            if(AEB==true)
//            {
//                //判断AEB结束
//                if(speed[i-1]-speed[i]<9)
//                {
//                    for(int j=0;j<4;j++)
//                        if(i+j<len)
//                        {
//                            ret.push_back(speed[i+j]);
//                            //这里需要注意，在AEB结束的2s内是需要判断下一次AEB的
//                            if(speed[i+j-1]-speed[i+j]>=9)
//                                curAEB++;
//                            else
//                                curAEB==0;
//                        }
//                    timer = 0;
//                    lastAEB = i+3;
//                    i += 3;
//                    AEB = false;
//                }
//                else{
//                    ret.push_back(speed[i]);
//                }
//            }
//            //判断AEB开始
//            else if(speed[i-1]-speed[i]>=9)
//            {
//                curAEB++;
//                if(curAEB>=4){
//                    curAEB = 0;
//                    AEB = true;
//                    timer = 0;
//                    //找前四个点，看是不是比上一次的末尾大，推入
//                    for(int j=i-7;j<=i;j++)
//                        if(j>lastAEB)
//                            ret.push_back(speed[j]);
//
//                }
//            }
//            else
//                curAEB = 0;
//            //正常计速
//            if(timer==60&&!AEB)
//            {
//                timer = 0;
//                ret.push_back(speed[i]);
//            }
//            timer++;
//        }
//
//
//        return ret;
//    }
//
//    int main(){
//        int n;
//        cin>>n;
//        vector<int> speed(n);
//        for(int i=0;i<n;i++)
//        {
//            cin>>speed[i];
//        }
//        vector<int> upload = uploadSpeeds(speed);
//        int len = upload.size();
//        for(int i =0;i<len-1;i++)
//            cout<<upload[i]<<',';
//        cout<<upload[len-1]<<endl;
//    }
}
