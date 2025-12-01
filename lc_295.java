class MedianFinder {

    private final PriorityQueue<Integer> min; 
    private final PriorityQueue<Integer> max; 
    private boolean even;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            max.offer(num);
            min.offer(max.poll());
        } else {
            min.offer(num);
            max.offer(min.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        return even ? (max.peek() + min.peek()) / 2.0 : min.peek();
    }
}
