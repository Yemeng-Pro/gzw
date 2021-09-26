package 找规律题;

public class 一次编辑 {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1-len2)>1) return false;

        int i = 0;
        int j = 0;
        while((i<len1 && j<len2) && (first.charAt(i) == second.charAt(j))){
            i++;
            j++;
        }
        if(len1 == len2){
            i++;
            j++;
        }else if(len1 > len2){
            i++;
        }else{
            j++;
        }

        while(i<len1 && j<len2){
            if(first.charAt(i)!=second.charAt(j)) return false;
            i++;
            j++;
        }
        return true;


    }
}
