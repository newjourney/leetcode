package bytedance.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 
 * @author xingkai.zhang
 */
public class LengthOfLongestSubstring {

    public static int method1(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int longest = 0;
        int tmp = 0;
        List<Character> has = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            char c = chars[i];
            if (has.contains(c)) {
                if (tmp > longest) {
                    longest = tmp;
                }
                int idx = has.indexOf(c);
                tmp -= idx;
                for (;;) {
                    if (idx >= 0)
                        has.remove(idx--);
                    else
                        break;
                }
            } else {
                tmp++;
            }
            has.add(c);
            if (i == length - 1 && tmp > longest) {
                longest = tmp;
            }
        }
        return longest;
    }
    
    public static int method2(String s) {
        Map<Character, Integer> record = new HashMap<>();
        char[] chars = s.toCharArray();
        int longest = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Integer old = record.get(c);
            if (old == null || old < left) {
                longest = Math.max(longest, i - left + 1);
            } else {
                left = old + 1;
            }
            record.put(c, i);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(method2("tmmzuxt"));
        System.out.println(method2("pwwkew"));
    }

}
