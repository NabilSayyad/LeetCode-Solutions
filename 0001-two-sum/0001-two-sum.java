/*

Approach 1 : Nested for loops

TC : O(N^2)
SC : O(1)

Approach 2 : Using Hashmap

TC : O(N)
SC : O(N)

Approach 3 :

Sort the array

Use two pointers: left and right

if arr[left] + arr[right] > target, then right = right - 1

if arr[left] + arr[right] < target, then left = left + 1

if arr[left] + arr[right] == target, then stop

TC : O(NlogN) + O(N) equivalent to O(NlogN)

SC : O(1)


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
           int complement = target - nums[i];
           if(map.containsKey(complement)){
               ans[0] = i;
               ans[1] = map.get(complement);
               return ans;
           }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}