package bytedance.string;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 
 * @author xingkai.zhang
 */
public class CheckInclusion {

    public static boolean method1(String s1, String s2) {
        int[] ints1 = new int[26], ints2 = new int[26];
        int l1 = s1.length();
        for (int i = 0; i < l1; i++) ints1[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++) {
            if (i >= l1) ints2[s2.charAt(i - l1) - 'a']--;
            ints2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(ints1, ints2)) return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        System.out.println(method1("ab", "acdebf"));
    }
}
