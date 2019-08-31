package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 14:15
 **/
public class 有效的括号 {
    public static void main(String[] args) {
        Solution12 solution=new Solution12();
        System.out.println(solution.isValid("([)"));
    }
}

class Solution12 {
    public boolean isValid(String s) {
        HashMap map=new HashMap<>();
        map.put("[","]");
        map.put("(",")");
        map.put("{","}");
        Stack<String> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.substring(i,i+1));
            }else{
                String c=(String)stack.peek();
                if(s.substring(i,i+1).equals(map.get(c))){
                    stack.pop();
                }else{
                    stack.push(s.substring(i,i+1));
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
