package com.ssm.leetcode.l_0208;

import java.util.HashSet;
import java.util.Set;

/**
 * @author quandaoran
 * @date 2020-02-08
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode2 {


    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        int max = 0;

        int length = chars.length;

        if (length == 1) {
            return 1;
        }

        for (int i = 0; i < length; i++) {

            Set<Character> set = new HashSet<>();

            set.add(chars[i]);

            for (int j = i + 1; j < length; j++) {
                char jchar = chars[j];
                if (set.contains(jchar)) {
                    break;
                } else {
                    set.add(jchar);
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcbc";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            System.out.println(j);

        }
    }
}
