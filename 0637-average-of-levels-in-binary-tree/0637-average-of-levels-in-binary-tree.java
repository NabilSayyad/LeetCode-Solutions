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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAvg = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return levelAvg;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int currLevelSize = queue.size();
            for(int i = 0; i < currLevelSize; i++){
                TreeNode curr = queue.remove();
                sum += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            levelAvg.add(sum/currLevelSize);
        }
        return levelAvg;
    }
}