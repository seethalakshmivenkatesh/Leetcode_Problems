/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

      
        if (left[0] == 1 && right[0] == 1 &&
            node.val > left[2] && node.val < right[1]) {

            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum);

            int minVal = Math.min(left[1], node.val);
            int maxVal = Math.max(right[2], node.val);

            return new int[]{1, minVal, maxVal, sum};
        } else {
           
            return new int[]{0, 0, 0, 0};
        }
    }
}
