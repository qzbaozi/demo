package com.sfh.tree;

/**
 * @user sfh
 * @date 2021/11/26 14:30
 */
public class tree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};

        tree_108 tree_108 = new tree_108();
        TreeNode treeNode = tree_108.sortedArrayToBST(arr);

        treeNode.print(treeNode);
    }
}