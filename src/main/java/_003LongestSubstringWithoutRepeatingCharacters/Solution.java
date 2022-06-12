package _003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-04 16:22
 **/
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    // s = "abcabcbb"
    // abc
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            map.put(s.charAt(end), end + 1);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}