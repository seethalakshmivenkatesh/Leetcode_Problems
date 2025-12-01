/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pv = p.val;
        int qv = q.val;

        TreeNode node = root;

        while (node != null) {
            if (pv < node.val && qv < node.val) {
                node = node.left;     
            } else if (pv > node.val && qv > node.val) {
                node = node.right;   
            } else {
                return node;         
            }
        }
        return null;
    }
}
