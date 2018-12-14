package bytedance.string;

/**
 * 151. 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 示例:
 * 输入: "the sky is blue", 输出: "blue is sky the". 
 * 
 * 说明:
 * 无空格字符构成一个单词。 
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * @author xingkai.zhang
 */
public class ReverseWords {

    public static String method(String s) {
        String[] ss = s.split(" ");
        int length = ss.length;
        StringBuilder ret = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            String tmpS = ss[i];
            if (!tmpS.equals("") && !tmpS.equals(" ")) {
                ret.append(tmpS).append(" ");
            }
        }
        return ret.length() == 0 ? "" : ret.substring(0, ret.length() - 1);
    }
    
    
    public static void main(String[] args) {
        System.out.println(method("   the  sky  is blue  "));
    }
}
