// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int n = matrix[0].length;
//         int m = matrix.length;
//         int[] ans = new int[m*n];
        
//         int srow = 0 ;
//         int scol = 0 ;
//         int erow = m-1 ;
//         int ecol = n-1 ;
//         int idx = 0;

//         while(srow<=erow && scol<=ecol){
//             for(int j = scol ; j <= ecol ; j++){
//                 ans[idx++] = matrix[srow][j];
//             }
//             for(int i = srow+1 ; i <= erow ; i++){
//                 ans[idx++] = matrix[i][ecol];
//             }

//             for(int j = ecol-1 ; j >= scol ; j--){
//                 if(ecol == scol){
//                     break;
//                 }
//                 ans[idx++] = matrix[erow][j];
//             }

//             for(int i = erow-1 ; i >= srow+1 ; i--){
//                 if(srow == erow){
//                     break;
//                 }
//                 ans[idx++] = matrix[i][scol];
//             }

//             srow++;
//             scol++;
//             erow--;
//             ecol--;
//         }
        
//         List<Integer> res = new ArrayList<>();
//         for(int i = 0 ; i < idx ; i++){
//             res.add(ans[i]);
//         }
//         return res;
//     }
// }
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //if (matrix == null || matrix.length == 0) return new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];

        int srow = 0, scol = 0;
        int erow = m - 1, ecol = n - 1;
        int idx = 0;

        while (srow <= erow && scol <= ecol) {
            // 1️⃣ top row →
            for (int j = scol; j <= ecol; j++) {
                ans[idx++] = matrix[srow][j];
            }

            // 2️⃣ right column ↓
            for (int i = srow + 1; i <= erow; i++) {
                ans[idx++] = matrix[i][ecol];
            }

            // 3️⃣ bottom row ←
            for (int j = ecol - 1; j >= scol; j--) {
                if (srow == erow) break; // ✅ fixed condition
                ans[idx++] = matrix[erow][j];
            }

            // 4️⃣ left column ↑
            for (int i = erow - 1; i > srow; i--) {
                if (scol == ecol) break; // ✅ fixed condition
                ans[idx++] = matrix[i][scol];
            }

            srow++;
            scol++;
            erow--;
            ecol--;
        }

        // Convert ans[] → List<Integer>
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            res.add(ans[i]);
        }

        return res;
    }
}
