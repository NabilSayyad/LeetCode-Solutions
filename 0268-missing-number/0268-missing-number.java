/*

Approach 1 : 
Expected sum should be length * (length+1)/2
Calculate Array sum 
Missing number = Expected Sum - Array Sum

Approach 2 : 

Range          : 0,1,2....n
Actual numbers : 0........n(with one number missing)
XOR of these two ranges will cancel out all numbers that are
in range and that are in actual array.
The XOR will be the only number which is in range but not in actual array

public int missingNumber(int[] nums) {
        int i;
        int ans = 0;
         for(i=0; i< nums.length; i++){
             ans = ans ^ nums[i] ^ i;
         }
         return ans^i;
    }


TC : O(N)
SC : O(1)


Approach 3 : 

Cyclic Sort

nums = [3,0,1]
total numbers : 3
range of numbers : 0 to 3
expected = [0,1,2,3] i.e. number 0 expected at index 0

Pls handle the case where num is 3 and our array doesn't have index 3, so for such cases, skip this index.

Algo : 

Run a while loop from 0 to last index

If arr[expectedIndex] == currValue => then move to next index
Else do a swap and stay at the same index

Ensure that expectedIndex does not cross array boundaries, so before comparison do a boundary check

TC : O(N)
SC : O(1)

*/

class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int i=0;
        while(i < nums.length){
            int currValue = nums[i];
            int expectedIndex = currValue;
            if(expectedIndex < length && currValue != nums[expectedIndex]){
                swap(nums, i, expectedIndex);
            }
            else{
                i++;
            }
        }
        for(i=0; i<nums.length; i++){
            if(nums[i] != i){
                break;
            }
        }
        return i;
    }
    
    private static void swap(int[] nums, int src, int dest){
        int temp = nums[src];
        nums [src] = nums[dest];
        nums[dest] = temp;
    }
}