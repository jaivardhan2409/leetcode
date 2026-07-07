class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //min heap stores climbs where u are using ladders
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < heights.length - 1; i++){
            int diff = heights[i+1] - heights[i];
            //nothing is requires if next building is shorter or equal
            if(diff <=0)
              continue;
            
            //Assume krte hai ki ladder is used to climb
            pq.offer(diff);

            //If ladder exceed, use brick  for climbing
            if(pq.size()> ladders){
                bricks -= pq.poll();
            }
            //u cannot move futher
            if(bricks < 0)
              return i;
        }
        //reached the last building
        return heights.length - 1;
    }
}