package bytedance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135" 
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 * TODO 还没理解
 * 
 * @author xingkai.zhang
 */
public class RestoreIpAddresses {

    public static List<String> method1(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private static void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);
        
        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(method1("25525511135"));
    }
    
}
