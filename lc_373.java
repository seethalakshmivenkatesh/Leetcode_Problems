class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

      
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0}); 
            
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();

            res.add(List.of(top[0], top[1]));

            int idx = top[2];
            if (idx + 1 < nums2.length) {
                pq.offer(new int[]{top[0], nums2[idx + 1], idx + 1});
            }
        }

        return res;
    }
}
