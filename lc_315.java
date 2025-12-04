class Solution {
    int[] nums;
    int[] index;      
    int[] result;     

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.index = new int[n];
        this.result = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i; 
        }

        mergeSort(0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int x : result) ans.add(x);
        return ans;
    }

    private void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int rightCount = 0;

        int[] temp = new int[right - left + 1];
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[index[j]] < nums[index[i]]) {
                rightCount++;
                temp[k++] = index[j++];
            } else {
                result[index[i]] += rightCount;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            result[index[i]] += rightCount;
            temp[k++] = index[i++];
        }

        while (j <= right) {
            temp[k++] = index[j++];
        }

   
        for (int t = 0; t < temp.length; t++) {
            index[left + t] = temp[t];
        }
    }
}

