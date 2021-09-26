package 纯编程题;

import java.util.Arrays;

public class IP地址无效化 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
    public String defangIPaddr2(String address) {
        char[] chars = address.toCharArray();
        char[] res = new char[chars.length + 6];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.'){
                res[j++] = '[';
                res[j++] = '.';
                res[j++] = ']';
            }else{
                res[j++] = chars[i];
            }
        }
        return String.valueOf(res);
    }
    public String defangIPaddr3(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); ++i) {
            char c = address.charAt(i);
            if (c != '.') {
                sb.append(c);
            } else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

}
