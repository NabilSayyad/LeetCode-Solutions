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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return levelOrderTraversal;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currLevelList = new ArrayList<>();
            int currLevelSize = queue.size();
            while(currLevelSize-- > 0){
                TreeNode node = queue.remove();
                currLevelList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            levelOrderTraversal.add(currLevelList);
        }
        return levelOrderTraversal;
    }
}