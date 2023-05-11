/*
range of numbers : 1,2,3....N
indices in array : 0,1,2,3...N-1

Expected index = Number - 1

Apply cyclic sort

Iterate and return all the numbers not at their correct positions.

Algo : 

Run a while loop from 0 to last index

If (expectedIndex in bounds && arr[expectedIndex] != currValue) => do a swap and stay at the same index
Else move to next index

TC : O(N)
SC : O(1)


*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
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
                disappearedNumbers.add(nums[i]);
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