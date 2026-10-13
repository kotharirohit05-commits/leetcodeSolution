class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int size = (n + 1) / 2;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        int[] dup = new int[n];
        for(int i = 0; i < n; i++){
            dup[i] = Math.abs(nums[i]);
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(dup[i]);
        }
        Collections.sort(list, (a, b) -> b - a);

        int k = 0;
        for(int i = 0; i < size; i++){
            arr1[k++] = list.get(i);
            System.out.println(arr1[i]);
        }

        for(int i = 0; i < size; i++){
            if(k < n){
                arr2[i] = list.get(k++);
            }else{
                continue;
            }
            
            System.out.println(arr2[i]);
        }
        

        long s1 = 0;
        long s2 = 0;

        for(int i = 0; i < arr1.length; i++){
            s1 += Math.pow(arr1[i], 2);
        }
        for(int i = 0; i < arr2.length; i++){
            s2 += Math.pow(arr2[i], 2);
        }

        long ans = s1 - s2;
        return ans;
    }
}