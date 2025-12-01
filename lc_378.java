class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int r = 0; r < n; r++) {
            heap.offer(new int[]{matrix[r][0], r, 0});
        }

   
        for (int i = 0; i < k - 1; i++) {
            int[] top = heap.poll();
            int row = top[1];
            int col = top[2];

      
            if (col + 1 < n) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return heap.poll()[0];
    }
}
