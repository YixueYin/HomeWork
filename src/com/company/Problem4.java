package com.company;
/*4. 求两数之和【难度：难】
        给定2个非空的链表，每个链表代表一个正整数，链表中的每个节点包含正整数中的一个数字，数据以逆序存储，求2个数的和，并将结果以一个链表的形式返回。
        样例:
        输入: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出: 7 -> 0 -> 8
        解释: 342 + 465 = 807.

        请补全以下代码：
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Problem4 {
    public static void main(String[] args) {
        //{3,4,2},{4,6,5}
        ListNode a1=new ListNode(3);
        ListNode a2=new ListNode(4);
        ListNode a3=new ListNode(2);

        a1.next=a2;
        a2.next=a3;

        ListNode b1=new ListNode(4);
        ListNode b2=new ListNode(6);
        ListNode b3=new ListNode(5);

        b1.next=b2;
        b2.next=b3;

        ListNode r=addTwoNumbers(a1,b1);
        List<Integer> result=new ArrayList<>();
        while (r!=null)
        {
            result.add(r.val);
            r=r.next;
        }
        System.out.printf("(2->4->3)+(5->6->4)=(%s)\n",result.stream().map(Objects::toString).collect(Collectors.joining("->")));

    }

    public static class ListNode{
        public int value;
        int val;
        ListNode next;
        ListNode(int x)
        {
            val=x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
        {
            return l1==null? l2 : l1 ;
        }
        int value=l1.val+l2.val;
        ListNode result=new ListNode(value%10);
        //节点相加
        result.next=addTwoNumbers(l1.next,l2.next);
        //节点相加的结果和余数相加
        if(value>=10)
        {
            result.next=addTwoNumbers(new ListNode(value/10),result.next);
        }
        return result;
    }

}


