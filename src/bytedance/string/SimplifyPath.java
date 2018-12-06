package bytedance.string;

import java.util.Stack;

/**
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 
 * 例如， path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * 边界情况: 你是否考虑了 路径 = "/../" 的情况？ 在这种情况下，你需返回 "/" 。 此外，路径中也可能包含多个斜杠 '/'
 * ，如"/home//foo/" 。 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * 
 * @author xingkai.zhang
 */
public class SimplifyPath {

    // 典型的栈结构
    public static String method1(String path) {
        String[] ss = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : ss) {
            s = s.trim();
            if (s.isEmpty() || ".".equals(s))
                continue;
            if (!"..".equals(s)) {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty())
            return "/";
        StringBuilder ret = new StringBuilder("/");
        for (String s : stack) {
            ret.append(s).append("/");
        }
        return ret.substring(0, ret.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(method1("/a/./b/../../c/"));
        System.out.println(method1("/../"));
    }

}
