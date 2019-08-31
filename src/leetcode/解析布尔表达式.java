package leetcode;

import java.util.Stack;

/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 *
 *
 * 思路：如果遇到t或者f，直接返回true或者false。
 * 从左到右遍历表达式，遇到逗号直接跳过，遇到非右括号的字符压到栈里，遇到右括号则弹出栈里的元素直至左括号弹出，然后再弹出一个元素，最后弹出的元素（弹出左括号之后弹出的元素）一定是运算符。
 * 对于弹出的元素，根据t和f的数量以及运算符判断运算结果是t或者f，将新的运算结果压到栈里。直到栈里只剩一个元素，这个元素一定是t或者f，根据该元素的值返回结果。
 *

 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-29 00:17
 **/
public class 解析布尔表达式 {
    public static void main(String[] args) {
        String a="abcd";
        System.out.println(a.toCharArray());
    }

}

class Solution5 {
    public boolean parseBoolExpr(String expression) {
        if (expression.equals("t")){
            return true;
        }
        else if (expression.equals("f")){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = expression.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (c == ','){
                continue;
            }
            else if (c != ')'){
                stack.push(c);
            }
            else {
                int tCount = 0, fCount = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        tCount++;
                    }
                    else if (val == 'f'){
                        fCount++;
                    }
                }
                //弹出左括号
                stack.pop();
                char op = stack.pop();
                char nextVal = 'u';
                if (op == '&') {
                    if (fCount == 0){
                        nextVal = 't';
                    }
                    else{
                        nextVal = 'f';
                    }

                } else if (op == '|') {
                    if (tCount > 0){
                        nextVal = 't';
                    }
                    else{
                        nextVal = 'f';
                    }
                } else if (op == '!') {
                    //！后面的括号里只有一个
                    if (tCount == 1){
                        nextVal = 'f';
                    }
                    else{
                        nextVal = 't';
                    }

                }
                stack.push(nextVal);
            }
        }
        char lastChar = stack.pop();
        boolean res = (lastChar == 't' ? true : false);
        return res;
    }
}

