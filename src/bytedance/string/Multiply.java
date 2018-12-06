package bytedance.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * </p>
 * @author xingkai.zhang
 */
public class Multiply {
    
    public static String method1(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int mi = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int mu1 = mi * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                mu1 += pos[p2];
                pos[p1] += mu1 / 10;
                pos[p2] = mu1 % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() != 0 ? sb.toString() : "0";
    }
    
    public static void main(String[] args) {
        System.out.println(method1("32", "45"));
    }
    
}
