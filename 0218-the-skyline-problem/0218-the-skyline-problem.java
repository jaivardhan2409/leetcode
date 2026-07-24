class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for(int[] b : buildings){
            events.add(new int[]{b[0], -b[2]});
            //event ko end krenge
            events.add(new int[]{b[1], b[2]});
        }

            Collections.sort(events, (a, b) -> {

                if(a[0] != b[0])
                   return a[0]-b[0];

                return a[1] - b[1];
            });

            //max heap
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            maxHeap.offer(0);
            int prevMax = 0;
            List<List<Integer>> answer = new ArrayList<>();
            for(int[] event : events){
                int x = event[0];
                int h = event[1];

                if(h < 0){
                    maxHeap.offer(-h);
                }else{
                    maxHeap.remove(h);
                }


            

            int currentMax = maxHeap.peek();

            if(currentMax != prevMax){
                answer.add(Arrays.asList(x,currentMax));
                prevMax = currentMax;
            }
        }
        return answer;
    }
}