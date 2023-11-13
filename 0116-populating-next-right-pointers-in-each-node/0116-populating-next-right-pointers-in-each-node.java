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

/* Approach 1 : 

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
*/

/*

1 ptr : track the 1st node of each level -> leftmost
1 ptr : traverse the level -> head

*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        // similar to adding root in queue
        Node leftmost = root;
        
        // similar to checking if queue is empty
        while(leftmost.left != null){
            
            // this ptr will traverse the level
            Node curr = leftmost;
            
            while(curr != null){
                // Establish connection 1
                curr.left.next = curr.right;
                
                // Establish connection 2
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                curr = curr.next;
                
            }
            
            // one level completed so go to next level 
            leftmost = leftmost.left;
            
        }
        
        return root;
    }
}

