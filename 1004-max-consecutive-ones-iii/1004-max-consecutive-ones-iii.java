class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zero =0;
        int n = nums.length;
        for(int r=0;r<n;r++){
            if(nums[r] == 0){
                zero++;
            }
            if(zero>k){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
        }
        return n-left;
        
    }
}