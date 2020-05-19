package com.ssm.leetcode.algorithm;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author quandaoran
 * @date 2019-10-28
 * @description
 */
public class Solution1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * * <p>
     * * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * * <p>
     * * 示例:
     * * <p>
     * * 给定 nums = [2, 7, 11, 15], target = 9
     * * <p>
     * * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * * 所以返回 [0, 1]
     * * <p>
     * * 来源：力扣（LeetCode）
     * * 链接：https://leetcode-cn.com/problems/two-sum
     * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                if (target == num + num1) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
            System.out.println(map);
        }
        return res;
    }

    public class ListNode {

        int value;

        ListNode next;

        ListNode(int x) {
            value = x;
        }

        boolean hasNext() {
            return null != next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num = getNum(l1);
        String num1 = getNum(l2);
        int i = Integer.parseInt(num) + Integer.parseInt(num1);
        System.out.println(i);
        return null;
    }

    public String getNum(ListNode listNode) {
        List<Integer> list = new LinkedList<>();
        while (listNode.hasNext()) {
            list.add(listNode.value);
            listNode = listNode.next;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size(); i > 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        int[] ints = new int[]{2, 7, 11, 15};
//        int[] ints1 = solution1.twoSum2(ints, 13);
//        for (int i : ints1) {
//            System.out.println(i);
//        }
//        solution1.getNum()


        LinkedList<Object> strings = Lists.newLinkedList();
        strings.add("111");
        strings.add("222");
        Class<ThreadPoolExecutor> aClass = ThreadPoolExecutor.class;
    }

}
