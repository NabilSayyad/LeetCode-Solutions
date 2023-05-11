/*
indices         : 0, 1, 2, ... n-1
expected values : 1, 2, 3, ... n

Expected value = Index + 1

Algo : 

Run a for loop from 0 to last index

If arr[expectedIndex] == currValue => then move to next index
Else do a swap and stay at the same index

Ensure that expectedIndex does not cross array boundaries

*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       int length = nums.length;
       List<Integer> ans = new ArrayList<>();
       int idx = 0;
       while(idx < length){
           int currValue = nums[idx];
           int expectedIndex = currValue - 1;
           if(nums[expectedIndex] != currValue){
               swap(nums, idx, expectedIndex);
           }
           else{
               idx++;
           }
       }
       for(int i = 0; i < length; i++){
           if(nums[i] != i+1){
               ans.add(i+1);
           }
       }
       return ans;
    }
    
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}