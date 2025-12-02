class Solution {
private class Node{
    private int idx;
    private int diff;
    Node(int idx, int diff){
        this.idx = idx;
        this.diff = diff;
    }
}


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> ((b.diff == a.diff) ? (b.idx - a.idx) : (b.diff - a.diff)));
        for(int i = 0; i< arr.length; i++){
            pq.offer(new Node(i, Math.abs(arr[i] - x)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(arr[pq.poll().idx]);
        }
        Collections.sort(ans);
        return ans;
    }
}
