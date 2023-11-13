
/*

Same as level order traversal with only difference being that only the last one from each level gets to be part of the answer.

So at the end of each for loop, just add the last element removed from the queue to the answer.

TC : O(N)
SC : O(N)
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            TreeNode curr = null;
            while(currLevelSize-- > 0){
                curr = queue.remove();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans.add(curr.val);
        }
        return ans;
    }
}