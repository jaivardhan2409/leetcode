

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> Map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int c = target - nums[i];

            if(Map.containsKey(c)){
                return new int[]{Map.get(c),i};

            }
            Map.put(nums[i],i);
        }
        return new int[]{};
    }
}