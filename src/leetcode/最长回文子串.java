package leetcode;

import static java.lang.Math.max;

/**
 * p[i,j]表示以i开头以j结尾的是否是回文串，1表示是，0表示不是
 * 初始状态 p[i,i]=1  如果s[i]=s[i+1] p[i,i+1]=1
 * 如果s[i]=s[j] 且 p[i+1,j-1]=1 则p[i][j]=1;
 * * @description ${description}
 * @author: Mr.Wang
 * @create: 2019-08-28 17:34
 **/
public class 最长回文子串 {
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        String result=solution.longestPalindrome("abcba");
        System.out.println(result);

    }
}

class Solution2 {
    public String longestPalindrome(String s) {
        //考虑字符串长度为0和1的情况
        if(s.length()<=1){
            return s;
        }
        //2个以上
        int max=1;
        String longs=s.substring(0,1);
        int len=s.length();
        int[][] arr=new int[len][len];
        for(int i=0;i<len;i++){
            if(i<len-1){
                if(s.charAt(i)==s.charAt(i+1)){
                    arr[i][i+1]=1;
                    max=2;
                }
            }
            arr[i][i]=1;
        }
        //表示以i结尾的字符串
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(i-j>=2){
                    if(s.charAt(i)==s.charAt(j)&&arr[j+1][i-1]==1){
                        arr[j][i]=1;
                        if(max<i-j+1){
                            max=i-j+1;
                        }
                    }
                }

            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(j>i&&j-i+1==max&&arr[i][j]==1){
                    longs=s.substring(i,j+1);
                }
            }
        }
        return longs;
    }
    public String longestPalindrome2(String s) {
        if(s.length()<=1){
            return s;
        }
        int n=s.length();
        int[][] dp=new int[n][n];
        int maxlen = 1;     //保存最长回文子串长度
        int start = 0;      //保存最长回文子串起点
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j <= i; ++j)
            {
                if(i - j < 2)
                {
                    dp[j][i] = (s.charAt(i)==s.charAt(j)?1:0);
                }
                else
                {
                    dp[j][i] = ((s.charAt(i)==s.charAt(j) )&& dp[j + 1][i - 1]==1)?1:0;
                }

                if(dp[j][i]==1 && maxlen < i - j + 1)
                {
                    maxlen = i - j + 1;
                    start = j;
                }
            }
        }

        return s.substring(start,start+maxlen);
    }

}