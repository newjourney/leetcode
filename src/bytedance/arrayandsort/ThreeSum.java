package bytedance.arrayandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * @author xingkai.zhang
 */
public class ThreeSum {

    // 先排序，然后遍历元素, 取值为a, 在后面的元素中，分别从头和尾取值, 
    // 如果三数之和大于0，则尾部左移，如果小于0，则头部右移，如果相等，则得到一个结，并头尾同时移动。
    public static List<List<Integer>> method1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;  
            int left = i + 1, right = length - 1;
            while (left < right) {
                int s = a + nums[left] + nums[right];
                if (s > sum) right--;
                else if (s < sum) left++;
                else {
                    ret.add(Arrays.asList(a, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        System.out.println(method1(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
