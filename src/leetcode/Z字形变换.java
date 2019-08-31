package leetcode;

/**
 * @program: javabased
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-08-30 09:31
 **/
public class Z字形变换 {
}

class Solution7 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int len = Math.min(s.length(), numRows);
        String []rows = new String[len];
        for(int i = 0; i< len; i++) {
            rows[i] = "";
        }
        int loc = 0;  //loc的范围是0到numRows-1
        boolean down = false;//down为false标识向

        for(int i=0;i<s.length();i++) {
            rows[loc] += s.substring(i,i+1);//在那一行中加
            if(loc == 0 || loc == numRows - 1)
            {
                down = !down;
            }
            loc += down ? 1 : -1;
        }

        String ans = "";
        for(String row : rows) {
            ans += row;
        }
        return ans;
    }
}

