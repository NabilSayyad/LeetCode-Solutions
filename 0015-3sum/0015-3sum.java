/*
One of the best questions on leetcode

Traps : 
1) All triplets need to be returned
2) Duplicate triplets should not be returned

How to solve these traps?

1) All triplets need to be returned : 

2-sum returns only one combination
For it to be able to return all combinations,

even after nums[start] + nums[end] == target,
we need not return anything, instead capture the response in a list and move start to right and end to left in search of further pairs.

What if new start and new end are also same as previous start and previous end, it will give us duplicate answer. 

To avoid this, do start++ till I do not find a non-duplicate start value without crossing high

Also, do end-- till I do not find a non-duplicate end value without crossing low


2) Duplicate triplets should not be returned

What we did in above step ensured that for a triplet <t1, t2, t3>, t2 and t3 will not be repeated.

However, we also need to ensure that t1 is not repeated for a pair of t2 and t3.

Lets say sorted array is : 0,0,0,0

First triplet we got is : 0,0,0

Now when we call 2 sum for 0 at index 1, 2 sum returns us 0,0
So again the same triplet will repeat.

To avoid this, while calling 2-sum only, check if the 2-sum has already been called for this number. Since our array is sorted, so if 2-sum was already called for that number, then that number must be present at index 'i-1'.
So if number at index 'i' is same as that at index 'i-1', do not call 2-sum again.
Instead skip this number and go to the next number.

Ensure to take care of out of bounds while checking this.

TC : O(N^2 + NlogN)
SC : O(N)

One minor optimization : 
Once you see nums[i] > 0, break out of the for loop because no chance of getting sum as 0 now since array is already sorted amd numbers ahead of this will also be greater than 0 so we cannot get a triplet with sum as 0

So, loop needs to run till array.length-3 index 

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++){
            // If you are greater than 0, then break since no use of
            // looking ahead 
            if(nums[i] > 0){
                break;
            }
            // If its first element, then blindly call twoSum
            // If its not first element, then check for duplication
            // with previous one and then call twoSum
            if(i == 0 || nums[i] != nums[i-1]){
                twoSum(nums, ans, i);
            }
        }
        return ans;
    }
    
    public void twoSum(int[] nums, List<List<Integer>> ans, int index) {
        int low = index + 1;
        int high = nums.length - 1;
        int target = 0 - nums[index];
        while(low < high){
            if(nums[high] == target - nums[low]){
                ans.add(Arrays.asList(nums[index], nums[low], nums[high]));
                low++;
                high--;
                // Increment the low to point to a new value
                while(low < high && nums[low] == nums[low - 1]){
                    low++;
                }
                // Decrement the high to point to a new value
                while(low < high && nums[high] == nums[high + 1]){
                    high--;
                }
            }
            else if(nums[high] > target - nums[low]){
                high--;
            }
            else{
                low++;
            }
        }
    }
}