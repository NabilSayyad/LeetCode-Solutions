/*

Range of numbers : 1,2,3...N
Array indices    : 0,1,2,3....N

N numbers in range and N+1 indices... So there has to be atleast one repeated number

Question says only 1 number is repeated

1 is the least number and it can only come at index 0 after sorting. This shows that 
relation must be : Expected Index = Number - 1


Dry run for nums = [1,3,4,2,2]

1,3,4,2,2

1,4,3,2,2

1,2,3,4,2

2 at index 4 is not at expected place, so the duplicate number is 2

TC : O(N)
SC : O(1)

Algo : 

Run a for loop from 0 to last index

If arr[expectedIndex] == currValue => then move to next index
Else do a swap and stay at the same index

Ensure that expectedIndex does not cross array boundaries, so before comparison do a boundary check

*/

class Solution {
    public int findDuplicate(int[] nums) {
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
                break;
            }
        }
        return nums[i];
    }
    
    private static void swap(int[]nums, int i, int expectedIndex){
        int temp = nums[i];
        nums[i] = nums[expectedIndex];
        nums[expectedIndex] = temp;
    }
}