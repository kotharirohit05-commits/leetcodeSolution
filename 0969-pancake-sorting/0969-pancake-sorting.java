class Solution {

    private void flip(int[] arr , int k){
        int left = 0;
        int right = k - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        int number = arr.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int idx = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == number) {
                    idx = j;
                    break;
                }
            }


            if(idx == i){
                number--;
                continue;
            } 
            if(idx != 0){
                flip(arr , idx+1);
                ans.add(idx+1);
            }  

            flip(arr, i + 1);
            ans.add(i + 1); 

            number--;        

        }
        return ans;
    }

}