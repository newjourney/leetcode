package bytedance.arrayandsort;

/**
 * 33. 搜索旋转排序数组 
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * @author xingkai.zhang
 */
public class SearchInRotatedArray {

    // 画一下图就一目了然了，只比普通的二分查找稍稍复杂一点。
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            int lv = nums[left];
            if (lv == target) return left;
            int rv = nums[right];
            if (rv == target) return right;
            mid = left + (right - left) / 2;
            int mv = nums[mid];
            if (mv == target) return mid;
            if (mv < lv) {
                if (mv > target) {
                    right = mid;
                } else {
                    if (lv > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                if (mv < target) {
                    left = mid + 1;
                } else {
                    if (lv < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        int[] array = new int[] {4,5,6,7,8,1,2,3};
        System.out.println(search(array, 8));
    }
}
