/*
Same as level order traversal, only difference being keep a 
track of levelNumber and based upon that decide to reverse the sublist.

For odd levels, keep sublist as it is and add in the answer
For even levels, add in the answer by reversing the sublist

When to increment the level values?
Initialize level with 0
Process a level and then increment it
A level is processed when inner while loop ends 

So once the inner while loop ends, increment the level

How to reverse?
Collections.reverse(listName);

TC : O(N)
SC : O(N)

*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        if(root == null){
            return levelOrderTraversal;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currLevelList = new ArrayList<>();
            int currLevelSize = queue.size();
            for(int i = 0; i < currLevelSize; i++){
                TreeNode curr = queue.remove();
                currLevelList.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            if(level%2 == 0){
                levelOrderTraversal.add(currLevelList);
            }
            else{
                Collections.reverse(currLevelList);
                levelOrderTraversal.add(currLevelList);
            }
            level++;
        }
        return levelOrderTraversal;
    }
}