/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currLevelSize = queue.size();
            for(int i = 0; i < currLevelSize; i++){
                Node curr = queue.remove();
                if(i == currLevelSize - 1){
                    curr.next = null;
                }
                else{
                    curr.next = queue.peek();
                }
                // if(!queue.isEmpty() && i != currLevelSize - 1){
                //     curr.next = queue.peek();
                // }
                // else{
                //     curr.next = null;
                // }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
        }
        return root;
    }
}