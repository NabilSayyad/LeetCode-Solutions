/*

Case 1 : 1(low) 2 3 4(high)
needed = 5

low + high == needed
I am interested in smaller ones, hence I choose direction which gives me 
a smaller sum than what I got now.
Hence, I do right--

Case 2 : 1(low) 2 3 4(high)
needed = 3

low + high > needed
I am interested in smaller ones, hence I choose direction which gives me 
a smaller sum than what I got now.
Hence, I do right--

Case 3 : 

1(low) 2 3 4(high)

needed = 6

low + high < needed

Should I do low++ or high-- here?
If I do high-- here then I will get an even smaller sum and in all 3 cases, my high is decrementing so this is no longer a 2 pointer bcoz the window is shrinking just from one end.
Hence count combinations and move on by doing low++

Calculate how many combinations exist between low and high with one of the index as low which satisfy the condition.
Since the array is sorted, if low and high combination in a triplet satisfies the condition then 
low and high-1 will also satisfy the condition.
low and high-2 will also satisfy the condition.
low and high-3 will also satisfy the condition and so on

So the count will be => high - low

So once we have calculated fixing one index as low, move low to next index and now again low + high can be < needed or >= needed and so on.

*/

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int length = nums.length;
        if(length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i <= nums.length - 3; i++){
            count += twoSum(nums, target - nums[i], i);
        }
        return count;
    }
    
    public int twoSum(int[] nums, int needed, int index){
        int low = index + 1;
        int high = nums.length - 1;
        int count = 0;
        while(low < high){
            if(nums[low] < needed - nums[high]){
                count += high - low;
                low++;
            }
            else{
                high--;
            }
        }
        return count;
    }
}