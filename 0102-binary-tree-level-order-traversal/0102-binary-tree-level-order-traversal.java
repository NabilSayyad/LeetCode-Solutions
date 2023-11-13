/*
1. Check for the root if it is empty. If empty return and no need to proceed further.
2. Add root to the queue.
3. Run a while loop until queue becomes empty
4. Calculate the number of elements at the current level.
   We need to capture all these in a list, so have a LinkedList implementation of list.
5. Run a while loop on the number of elements at the current level already added in queue
6. For each element, remove it and check its left and right, add them in queue whenever      present.
7. Once the inner while loop completed, I have all the elements present
   at current level, so I add this list to the final answer and when nothing
   is left in the queue, we will return the answer.
 
Mental Map :

→ Inner while loop runs on all the nodes at a level.
  Hence, calculate currLevelSize and then run while loop

IMP : Do not directly use size() in inner while loop condition because we are adding to this queue inside the while loop.

→ Once inner while loop ends, all the elements at current level are
  processed, so add this sublist to the answer list.
 
TC : O(N)
SC : O(N)
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
            List<Integer> currLevelList = new LinkedList<>();
            int currLevelSize = queue.size();
            while(currLevelSize-- > 0){
                TreeNode curr = queue.remove();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                currLevelList.add(curr.val);
            }
            levelOrderTraversal.add(currLevelList);
        }
        return levelOrderTraversal;
    }
}