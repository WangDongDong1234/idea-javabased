package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-28 16:57
 **/
public class 无重复字符的最长字串 {

    public static void main(String[] args) {
        // String s="abcabcbb";
        // Solution2 solution=new Solution2();
        // List list=solution.lengthOfLongestSubstring(s);
        // System.out.println(list.toString());
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length()==0) {return 0;}
//         //记录字符对应的位置
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         int max = 0;
//         int left = 0;
//         for(int i = 0; i < s.length(); i ++){
//             if(map.containsKey(s.charAt(i))){
//                 //注意这是一个字串（字串必须连续），不是子序列
//                 //更新左起点的位置
//                 left = Math.max(left,map.get(s.charAt(i)) + 1);
//             }
//             map.put(s.charAt(i),i);
//             max = Math.max(max,i-left+1);
//         }
//         return max;
//
//     }
// }
//
// class Solution2 {
//     public List lengthOfLongestSubstring(String s) {
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         ArrayList<String> list=new ArrayList<>();
//         int max = 0;
//         int newMax =0;
//         int left = 0;
//         for(int i = 0; i < s.length(); i ++){
//             if(map.containsKey(s.charAt(i))){
//                 //注意这是一个字串（字串必须连续），不是子序列
//                 left = Math.max(left,map.get(s.charAt(i)) + 1);
//             }
//             map.put(s.charAt(i),i);
//             newMax = Math.max(max,i-left+1);
//             if(newMax>max){
//                 list=new ArrayList<>();
//                 max=newMax;
//             }else{
//                 list.add(s.substring(left,i+1));
//             }
//         }
//         return list;
//
//     }
// }
//
//
