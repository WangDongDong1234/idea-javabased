package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 10:17
 **/
public class 回溯法电话号码的字母组合 {
    public static void main(String[] args) {
        Solution10 solution10=new Solution10();
        System.out.println(solution10.letterCombinations("23"));
    }
}

class Solution10 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    //递归  combination存放临时结果
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            //得到数字对应的字母
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                //得到单个字母
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));//截取第二个字符串以后的
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }
}

