/*
Standard binary search question

Key points : 
1) Integer overflow should be avoided
2) While should always have low <= high instead of low < high
3) 3 cases so use else if properly
4) if not found, return -1

*/
/*
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            // Calculate middle element
            int mid = low + (high-low)/2;
            // Check for the 3 cases
            if(nums[mid] == target){
                // I have found the answer, so return its index
                return mid;
            }
            else if(nums[mid] > target){
                // My target lies to the left
                // Eliminate the right portion
                high = mid - 1;
            }
            else{
                // My target lies to the right
                // Eliminate the left portion
                low = mid + 1;
            }
        }
        // I didnt return anything till now, means
        // I didnt find my target
        // So I return -1 as per problem statement
        return -1;
    }
}
*/

// Order agnostic binary search

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        boolean ascSorted = nums[low] < nums[high];
        while(low <= high){
            // Calculate middle element
            int mid = low + (high-low)/2;
            // Check for the 3 cases
            if(nums[mid] == target){
                // I have found the answer, so return its index
                return mid;
            }
            else if(nums[mid] > target){
                if(ascSorted){
                    // My target lies to the left
                    // Eliminate the right portion
                    high = mid - 1;
                }
                else{
                    // My target lies to the right
                    // Eliminate the left portion
                    low = mid + 1;
                }
            }
            else{
                if(ascSorted){
                    // My target lies to the right
                    // Eliminate the left portion
                    low = mid + 1;
                }
                else{
                    // My target lies to the left
                    // Eliminate the right portion
                    high = mid - 1;
                }
            }
        }
        // I didnt return anything till now, means
        // I didnt find my target
        // So I return -1 as per problem statement
        return -1;
    }
}