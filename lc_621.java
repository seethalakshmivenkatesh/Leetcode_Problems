import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        Arrays.sort(freq);
        int f_max = freq[25];
        int count_max = 0;

     
        for (int i = 25; i >= 0 && freq[i] == f_max; i--) {
            count_max++;
        }

 
        int intervals = (f_max - 1) * (n + 1) + count_max;
        return Math.max(intervals, tasks.length);
    }
}
