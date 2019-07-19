package com.company;
/*
Question1
1. 查找最长的不重复子串【难度：中等】

        给定一个字符串，查找最长的不重复子串，返回其长度。
        样例 1:
        输入: "abcabcbb"输出: 3 解释: 不重复子串为 "abc", 长度为3.
        样例 2:
        输入: "bbbbb"输出: 1 解释: 不重复子串为 "b", 长度为1.
        样例 3:
        输入: "pwwkew" 输出: 3 解释: 不重复子串为 "wke", 长度为3.
        注意，答案必须是一个子串, "pwke" 不是一个子串.

        请补全以下代码：*/

import java.util.*;

/*Solution1
* 暴力解析：
* 遍历出给定字符串的所有子串，判断其中是否有重复字符，没有则记录长度，与下一次也无重复字符的子串比较长度，最长的即为所求*/
public class Problem1 {

    public static void main(String[] args) {
        System.out.println("请输入一个字符串，程序会帮您打印出最长的不重复子串的长度：");
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        System.out.println("最长的不重复子串的长度为："+noDuplicate(input));

    }
    public static int noDuplicate(String str)
    {
        if(str==null||str.length()==0)
        {
            return 0;
        }
        Set<String> set=new HashSet<>();
        String result="";
        /*System.out.println("length:"+str.length());*/
        for(int i=0;i<str.length();i++)
        {
            for(int j=i+1;j<=str.length();j++)
            {
                String s=str.substring(i,j);
                set.add(s);
            }
        }
        int max=0;
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            LinkedHashSet<String> setchar=new LinkedHashSet<>();
            String st=iterator.next().toString();
            for(int a=0;a<st.length();a++)
            {
                setchar.add(String.valueOf(st.charAt(a)));
            }
            if(setchar.size()==st.length())
            {
                int len=st.length();
                if(max<len)
                {
                    max=Math.max(max,len);
                    result =st;
                }
            }
        }
        return result.length();
    }
}
