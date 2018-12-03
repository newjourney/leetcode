package bytedance.string;

/**
 *
 * @author xingkai.zhang
 */
public class LongestCommonPrefix {

    public static String method1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String firstS = strs[0];
        if (firstS == null || firstS.length() == 0) return "";
        String ret = "";
        char[] firstC = firstS.toCharArray();
        for (int i = 0; i < firstC.length; i++) {
            char c = firstC[i];
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                String tmp = strs[j];
                if (tmp.length() <= i || tmp.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ret += c;
            } else {
                break;
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(method1(new String[] {"flower","flow","flight"}));
    }
}
