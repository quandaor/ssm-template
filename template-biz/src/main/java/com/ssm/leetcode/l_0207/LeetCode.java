package com.ssm.leetcode.l_0207;

import java.util.HashMap;

/**
 * @author quandaoran
 * @date 2020-02-07
 * @description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode {

    /**
     * 时间复杂度 O(n~2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }

            }
        }
        return new int[]{};
    }

    /**
     * @param nums
     * @param target
     * @return 根据元素找 返回下表   ------>   K - V
     * <p>
     * 算法最优 至少1遍遍历  即 O(n)
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[]{i, hashMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("Illegal arguments");
    }

    /**
     * @param nums
     * @param target
     * @return 根据元素找 返回下表   ------>   K - V
     * <p>
     * 算法最优  至少1遍遍历  即 O(n)
     * 优化第二种解法，在
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            目标值
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("Illegal arguments");
    }


    public static void main(String[] args) {
        int[] ints = {2, 3, 11, 15};
        int target = 5;
        int[] ints1 = twoSum3(ints, target);
        for (int i : ints1) {
            System.out.println(i);
        }
    }


}
