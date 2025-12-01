class Solution {
    public int[][] kClosest(int[][] points, int k) {

 
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]  
        );

        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];

            heap.offer(new int[]{dist, p[0], p[1]});

          
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = heap.poll();
            res[i][0] = top[1];
            res[i][1] = top[2];
        }

        return res;
    }
}
