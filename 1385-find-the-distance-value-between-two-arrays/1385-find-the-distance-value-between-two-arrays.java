import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        
        Arrays.sort(arr2);
        int distanceValue = 0;
        
        for (int x : arr1) {
            
            if (isValid(arr2, x - d, x + d)) {
                distanceValue++;
            }
        }
        
        return distanceValue;
    }
    
    private boolean isValid(int[] arr, int from, int to) {
        int left = 0;
        int right = arr.length - 1;
        
      
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= from && arr[mid] <= to) {
                
                return false; 
            } else if (arr[mid] < from) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return true;
    }
}
