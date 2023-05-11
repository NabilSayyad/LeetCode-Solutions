/*
Algo : 

Run a while loop from 0 to last index

If (expectedIndex in bounds && arr[expectedIndex] != currValue) => do a swap and stay at the same index
Else move to next index

*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int idx = 0;
        while(idx < length){
            int curr = nums[idx];
            int expectedIdx = curr - 1;
            if(expectedIdx >= 0 && expectedIdx < length && curr != nums[expectedIdx]){
                swap(nums, idx, expectedIdx);
            }
            else{
                idx++;
            }
        }
        for(idx = 0; idx < length; idx++){
            if(nums[idx] != idx + 1){
                break;
            }
        }
        return idx + 1;
    }
    
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}