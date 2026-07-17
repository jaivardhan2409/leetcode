class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxans=0;
        int currentcount=0;
        int j=0;
        int n=nums.length;
        while(j<n){
            if(nums[j] == 1){
                currentcount++;
            }
            else{
                maxans = Math.max(maxans,currentcount);
                currentcount=0;
            }
            j++;
        }
        return Math.max(maxans,currentcount);
    }
}