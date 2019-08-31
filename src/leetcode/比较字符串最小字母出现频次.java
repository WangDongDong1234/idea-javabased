package leetcode;

import java.util.Arrays;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 *
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-28 23:49
 **/
public class 比较字符串最小字母出现频次 {
    public static void main(String[] args) {
        System.out.println('a'<'b');
    }
}

class Solution3 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int wordsLen = words.length, index;
        Integer[] wordsCount = new Integer[wordsLen];
        for (int i = 0; i < words.length; i++) {
            wordsCount[i] = countMinCode(words[i]);
        }
        Arrays.sort(wordsCount);
        for (int i = 0; i < queries.length; i++) {
            int countMinQuery = countMinCode(queries[i]);
            //用二分查找，查比它小的有几个
            result[i] = wordsLen - 1 - BinSearch(wordsCount, countMinQuery);
        }
        return result;
    }

    public static int countMinCode(String s) {
        char min = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //a<b是true
            if (s.charAt(i) < min) {
                min = s.charAt(i);
                count = 0;
            }
            if (s.charAt(i) == min) {
                count++;
            }
        }
        return count;
    }

    public static int BinSearch(Integer[] a, int value) {
        int low = 0;
        int n = a.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}


