package bytedance.string;

/**
 * 14. 最长公共前缀
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
    
    public static String method2(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        String pattern = strs[0];
        for (int i = 1; i < n; i++) {
            String str = strs[i];
            while (str.indexOf(pattern) != 0) {
                pattern = pattern.substring(0, pattern.length() - 1);
                if (pattern.isEmpty()) return "";
            }
        }
        return pattern;
    }
    
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            method1(strs);
        }
        System.out.println(System.nanoTime() - start);
        
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            method2(strs);
        }
        System.out.println(System.nanoTime() - start);
    }
}
