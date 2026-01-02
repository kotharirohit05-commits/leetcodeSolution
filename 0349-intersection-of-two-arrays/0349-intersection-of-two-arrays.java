class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        Set<Integer> intersect = new HashSet<>();
        for(int n : nums2){
            if(set1.contains(n)){
                intersect.add(n);
            }
        }
        int[] arr = new int[intersect.size()];
        int i = 0;
        for(int n : intersect){
            arr[i++] = n;
        }
        return arr;
    }
}