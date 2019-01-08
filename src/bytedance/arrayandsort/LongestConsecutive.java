package bytedance.arrayandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 128. 最长连续序列 

 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2] 输出: 4 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * @author xingkai.zhang
 */
public class LongestConsecutive {

    // 遍历数组中的每个数字，然后算出相邻的递增数字的数量，再加上相邻的递减数字的数量。
    // 显然，这种方式包含很多的重复计算，不是最优方案。
    public static int method1(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1;
        Set<Integer> counts = new HashSet<>();
        for (int n : nums) {
            int tmp = 1;
            if (counts.contains(n)) continue;
            counts.add(n);
            while(counts.contains(--n)) {
                tmp++;
            }
            n = n + tmp;
            while(counts.contains(++n)) {
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }

    // 先把所有数字放入set. 
    // 然后遍历数组。如果数组中包含i - 1, 那就跳过。意思是，总是从一个序列中最小的数字开始计算连续递增数量。
    // 相比方法1，这种方法就过滤掉了很多重复计算。
    // for n, find the n+1 in the array.
    // we should always start from the smallest number in the sequence, so we skip numbers (n) when (n-1) is in the array
    public static int method2(int[] nums) {
        if (nums.length == 0)return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 1;
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int temp = 1;
                while (set.contains(i + 1)) {
                    i = i + 1;
                    temp++;
                }
                max = Math.max(temp, max);
            }
        }
        return max;
    }
    
    // 先排序再遍历的方式。这种算法的时间复杂度是nlog(n),但实际应用中，比方法2要快。
    public static int method3(int[] nums) {
        int max = 1, temp = 1;
        Arrays.sort(nums);
        int i = 0;
        if (nums.length == 0) {
            return 0;
        }
        while (i < nums.length - 1) {
            int diff = nums[i + 1] - nums[i];
            if (diff == 1 || diff == -1) {
                temp++;
            } else if (nums[i + 1] != nums[i]) {
                temp = 1;
            }
            if (max < temp) {
                max = temp;
            }
            i++;
        }
        return max;
    }
    
    private static int[] testCase() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        for (int i = 2000; i < 2500; i++) {
            list.add(i);
        }
        for (int i = 3000; i < 4000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int size = list.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = testCase();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            method1(nums);
        }
        System.out.println("method1 spends : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            method2(nums);
        }
        System.out.println("method2 spends : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            method3(nums);
        }
        System.out.println("method3 spends : " + (System.currentTimeMillis() - start));
    }

}
