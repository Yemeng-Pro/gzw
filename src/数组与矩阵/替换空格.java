package 数组与矩阵;

public class 替换空格 {
    public static String replaceSpace(String s){
        int length = s.length();
        char[] array = new char[length*3];
        int size = 0;
        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else{
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static String replaceSpace2(String s){
        //统计出字符串中空格的数目
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                count++;
            }
        }
        //新建一个字符数组，长度为原来字符串长度+空格数目*2
        char [] ch = new char[s.length() + count*2];
        //定义两个指针，分别指向原始字符串的末尾、替换之后的字符串的末尾
        int p1 = s.length() - 1;
        int p2 = ch.length -1;
        while (p1 >= 0 && p2 >= 0){
           // 若碰到空格，把P1向前移动一格子，在P2之前插入字符串"%20",然后把P2向前移动三格
            if (s.charAt(p1) == ' '){
                ch[p2] = '0';
                ch[p2-1] = '2';
                ch[p2-2] = '%';
                p1 -= 1;
                p2 -= 3;
            }
            // 否则，逐个把p1指向的字符复制到p2的位置
            else{
                ch[p2] = s.charAt(p1);
                p1 -= 1;
                p2 -= 1;
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String s = "We are happy";
        String c = replaceSpace2(s);
        System.out.println(c);
        String b = "i a i";
        int len = b.length();
        char[] word = {'i',' ','a',' ','i'};
        System.out.println(len);
        System.out.println(word.length);
    }
}
