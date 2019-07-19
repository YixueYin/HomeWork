package com.company;
/*2. 正则表达式匹配【难度：中等】
        给定一个输入字符串s, 和一个模式p, 实现正则匹配规则，支持. 和 *， 要求模式匹配整个输入字符串，而不是部分匹配。
        '.' 匹配任意一个字符.
        '*' 匹配零个或多个前序字符串.
        注意:
        •	s 可以为空，并且只包含小写的 a-z.
        •	p 可以为空，并且只包含小写的 a-z, 以及 . 和 *.
        样例 1:
        输入:
        s = "aa"
        p = "a"
        输出: false
        解释: "a" 不能匹配整个输入字符串 "aa".
        样例 2:
        输入:
        s = "aa"
        p = "a*"
        输出: true
        解释: '*' 代表零个或者多个前序字符串 'a'.因此，只要重复a一次，就可以得到输入字符串 "aa".
        样例 3:
        输入:
        s = "ab"
        p = ".*"
        输出: true
        解释: ".*" 代表零个或者多个任意字符 (.)".
        样例 4:
        输入:
        s = "aab"
        p = "c*a*b"
        输出: true
        解释: c 重复0次, a 重复2次. 因此它匹配输入字符串 "aab".
        样例 5:
        输入:
        s = "mississippi"
        p = "mis*is*p*."
        输出: false
        解释：p无法匹配输入字符串中的mississippi
*/


import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
       while (true){
           System.out.println("请给定一个输入字符串s, 和一个模式p");
           Scanner sc=new Scanner(System.in);
           String s=sc.nextLine();
           String p=sc.nextLine();
           if(isMatch( s,p)){
               System.out.println("true");
           }else{
               System.out.println("false");
           }

       }
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
            boolean first_match = (!s.isEmpty() &&
                    (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
            if (p.length() >= 2 && p.charAt(1) == '*'){
                return (isMatch(s, p.substring(2)) ||
                        (first_match && isMatch(s.substring(1), p)));
            } else {
                return first_match && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
