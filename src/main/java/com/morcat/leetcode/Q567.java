package com.morcat.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Q567_字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author shenzixing
 * @date 2024/3/8
 */
public class Q567 {

    /**
     * 滑动窗口解法!
     */
    class MySolution {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character,Integer> windows = new HashMap<>();
            Map<Character,Integer> need = new HashMap<>();
            for(Character c:s1.toCharArray()){
                need.put(c, need.getOrDefault(c, 0)+1);
            }
            int left = 0 ;
            int right = 0;
            while(right < s2.length()){
                windows.put(s2.charAt(right),windows.getOrDefault(s2.charAt(right), 0)+1);
                right++;
                while(right-left == s1.length()){
                    if(contains(windows, need)){
                        return true;
                    }
                    windows.put(s2.charAt(left),windows.getOrDefault(s2.charAt(left), 0)-1);
                    left++;
                }
            }
            return false;
        }

        private boolean contains(Map<Character,Integer> windows,  Map<Character,Integer> need){
            for(Character c : need.keySet()){
                if(!need.get(c).equals(windows.getOrDefault(c,0))){
                    return false;
                }
            }
            for(Character c : windows.keySet()){
                if(!windows.get(c).equals(need.getOrDefault(c,0))){
                    return false;
                }
            }
            return true;
        }
    }
}
