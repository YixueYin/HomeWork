package com.company;
/*

5. 二叉树广度优先遍历【难度：难】
        给定一个二叉树，返回节点的广度优先遍历结果（从上到下，从左到右，一层一层遍历）。
        样例:
        给定二叉树 [3,9,20,null,null,15,7],
        3
        / \
        9  20
        /  \
        15   7
        返回广度优先遍历结果:
        [
        [3],
        [9,20],
        [15,7]
        ]

        请补全以下代码：
*/

import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Problem5 {
    public static void main(String[] args) {
        int[] arr={3,9,20,0,0,15,7};
        Problem5 tree=new Problem5(arr);

        tree.levelOrderTraversal();

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root;
    public Problem5(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int val=array[index];
            if(val!=0){
                TreeNode t=new TreeNode(val);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }


    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.val+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

}
