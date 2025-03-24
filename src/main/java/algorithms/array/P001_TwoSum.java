package algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第1题: 两数之和
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class P001_TwoSum {
    
    /**
     * 解法1：暴力法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0]; // 不会执行到这里
    }
    
    /**
     * 解法2：哈希表
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // 不会执行到这里
    }
    
    // 测试
    public static void main(String[] args) {
        P001_TwoSum solution = new P001_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result1 = solution.solution1(nums, target);
        System.out.println("暴力法结果: [" + result1[0] + ", " + result1[1] + "]");
        
        int[] result2 = solution.solution2(nums, target);
        System.out.println("哈希表法结果: [" + result2[0] + ", " + result2[1] + "]");
    }
}
