class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        for( int i = 2; i <= right ;i++){
            prime[i] = true;
        }
        for(int i = 2; i * i <= right;i++){
            if(prime[i]){
                for(int j = i*i;j <= right; j+=i){
                    prime[j] = false;
                }
            }
        }
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] ans = {-1,-1};

        for(int i = Math.max(left, 2); i<= right;i++){
            if(prime[i]){
                if(prev != -1 && i - prev < minDiff){
                    minDiff = i - prev;
                    ans[0] = prev;
                    ans[1] = i;

                    if(minDiff == 2)
                      return ans;
                }
                prev = i;
            }
        }
        return ans;
    }

}