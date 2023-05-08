class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int lowestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(sum - target) < Math.abs(lowestDiff)){
                    lowestDiff = sum - target;
                }
                if(sum == target){
                    return target;
                }
                // Try to get to target
                else if(sum > target){
                    high--;
                }
                // Try to get to target
                else{
                    low++;
                }
            }
        }
        // lowestDiff = sum - target;
        // So sum = target + lowestDiff;
        return target + lowestDiff;
    }
}