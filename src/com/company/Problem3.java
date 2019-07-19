package com.company;
/*3. 两数之和【难度：中等】
        给定一个数字型数组，返回数组中的两个下标，两个下标对应的数之和等于一个给定值。
        假定，每个数组只有一个解决方案，即只要找到两个满足条件的下标，就不用接着往下找了。
        样例:
        给定数组nums = [2, 7, 11, 15], 目标和= 9,
        因为nums[0] + nums[1] = 2 + 7 = 9,
        返回[0, 1].

        请补全以下代码：*/

public class Problem3 {
    public static void main(String[] args) {
        System.out.println("给定数组nums = [2, 7, 11, 15], 目标和= 9");
        int[] nums=new int[4];
        nums[0]=2;
        nums[1]=7;
        nums[2]=11;
        nums[3]=15;

        System.out.print("{");
        for(int j=0;j<twoSum(nums,26).length;j++)
        {
            System.out.print(twoSum(nums,26)[j]+" ");
        }
        System.out.println("}");
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j]+nums[i]==target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
