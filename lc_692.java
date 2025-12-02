import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (freq.get(a).equals(freq.get(b))) {
                    return a.compareTo(b);
                }
                return freq.get(b) - freq.get(a);
            }
        );

        pq.addAll(freq.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}
