package com.sfh.tree;

import com.sfh.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @user sfh
 * @date 2021/11/26 14:30
 */
public class tree_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> list, int index) {
        if (root == null) {
            return;
        }

        List<Integer> integers ;
        if (list.size()>=index+1) {
            integers = list.get(index);
        }else {
            integers = new ArrayList<>();
            list.add(index, integers);
        }

        integers.add(root.val);

        levelOrder(root.left, list, index + 1);
        levelOrder(root.right, list, index + 1);
    }


}