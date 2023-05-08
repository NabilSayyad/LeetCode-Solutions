/*

Similar to 3 sum with an extra layer.

1st level condition for checking duplicates : 
Index should be 0 OR index should not be equal to previous one(i.e duplicate index)

2nd level condition for non-duplicate : 

ex : 1,1,1.....

So when my 'i' is at index 0 and 'j' is at index 1.
I need to find 2 sum for this configuration of i and j

Next my 'i' stays at 0 but 'j' moves to index 2.
Now I have got a repetition at 'j' level.
Hence we should skip it.

How to decide when not to skip?
If 'j' element is immediate next of 'i' element, then no need to check for duplicates.
If 'j' element is not immediate next as well as doesn't match its previous value.

Only if either of these 2 conditions meet, then go for finding 2 sum

TC : O(N^3)
SC : O(1)

*/

/*
class Solution {
    public List < List < Integer >> fourSum(int[] nums, int target) {
        List < List < Integer >> ansList = new ArrayList < > ();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                long threeSumTarget = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i+1 || nums[j] != nums[j - 1]) {
                        long twoSumTarget = threeSumTarget - nums[j];
                        int start = j + 1;
                        int end = nums.length - 1;
                        while (start < end) {
                            if (nums[start] + nums[end] == twoSumTarget) {
                                List < Integer > list = new ArrayList < > ();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[start]);
                                list.add(nums[end]);
                                ansList.add(list);
                                while (start < end && nums[start] == nums[start + 1]) {
                                    start++;
                                }
                                while (start < end && nums[end] == nums[end - 1]) {
                                    end--;
                                }
                                start++;
                                end--;
                            } else if (nums[start] + nums[end] > twoSumTarget) {
                                end--;
                            } else {
                                start++;
                            }
                        }

                    }
                }
            }
        }
        return ansList;
    }
}
*/



// Generalized k-sum
// TC : Two sum is O(N) and remaining levels are (k-2) which needs (k-2) loops.
// So total is O(N^(k-1))
// SC : O(k) for recursion stack space 

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    
    public List<List<Integer>> kSum(int[] nums, long target, int k, int index){
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(index >= nums.length){
            return res;
        }
        if(k == 2){
            int low = index;
            int high = nums.length - 1;
            while(low < high){
                if(nums[high] == target - nums[low]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    res.add(temp);
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high+1]){
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
        else{
            for(int i = index; i < nums.length - k + 1; i++){
                // use current number
                // So target gets reduced
                // Problem gets reduced to (k-1) sum on 
                // reduced array and reduced target
                List<List<Integer>> temp = kSum(nums, target - nums[i],
                                               k-1, i + 1);
                // kSum brings all the triplets and stores in temp
                // To these triplets, I am adding this current element at the start i.e. index 0
                if(temp != null){
                    for(List<Integer> t : temp){
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                // ex : 1 1 1 2
                // We need to stop at the last duplicate
                // and then i++ makes us skip that last duplicate 
                // and reach the non-duplicate value
                // Since we are checking with next values,
                // hence i+1 should be less than nums.length
                while(i+1 < nums.length && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return res;
    }
}