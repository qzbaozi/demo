package com.sfh.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @user sfh
 * @date 2021/11/26 14:35
 */
public class TreeNode {
    public int val;
    public  TreeNode left;
    public  TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print(TreeNode treeNode) {
        List<Integer> list=new ArrayList<>();
      getList(treeNode,list);
        System.out.println(list.toString());
    }

    private void getList(TreeNode treeNode, List<Integer> list) {
        if (treeNode==null){
            list.add(null);
            return;
        }

        list.add(treeNode.val);

        getList(treeNode.left,list);
        getList(treeNode.right,list);

    }
}
