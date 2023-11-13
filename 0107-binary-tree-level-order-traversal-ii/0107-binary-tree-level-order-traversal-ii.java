/*
Approach 1 : 
-> The code is as it is except that we need to return the reverse of what we get in level order traversal.

-> So we need to reverse the level order traversal before returning.

Collections.reverse(levelOrderTraversal);

Approach 2 : If we do not want to reverse it, then simply use add(index, value) and at every level, append the currLevelList at index 0

*/

/*

Approach 1 : 

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(levelOrderTraversal);
        return levelOrderTraversal;
    }
}

*/

/*Approach 2 */

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            levelOrderTraversal.add(0, currLevelList);
        }
        return levelOrderTraversal;
    }
}