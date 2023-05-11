/*
Straight forward application of cyclic sort

Algo : 

Run a while loop from 0 to last index

If arr[expectedIndex] == currValue => then move to next index
Else do a swap and stay at the same index

Ensure that expectedIndex does not cross array boundaries, so before comparison do a boundary check

TC : O(N)
SC : O(1)

*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] disappearedNumbers = new int[2];
        int i=0;
        int expectedIndex;
        while(i < nums.length){
            int currValue = nums[i];
            expectedIndex = currValue - 1;
            if(currValue != nums[expectedIndex]){
                swap(nums, i, expectedIndex);
            }
            else{
                i++;
            }
        }
        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return new int[]{nums[i], i+1};
            }
        }
        return disappearedNumbers;
    }
    
    private static void swap(int[]nums, int i, int expectedIndex){
        int temp = nums[i];
        nums[i] = nums[expectedIndex];
        nums[expectedIndex] = temp;
    }
}