class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>();
        int n = series1.length;
        int m = series2.length;
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(series1[i][0] < series2[j][0]){
                res.add(new ArrayList<>(Arrays.asList(series1[i][0] , series1[i][1] + series2[j][1])));
                i++;
            }else if(series1[i][0] > series2[j][0]){
                res.add(new ArrayList<>(Arrays.asList(series2[j][0] , series1[i][1] + series2[j][1] )));
                j++;
            }else {
                res.add(new ArrayList<>(Arrays.asList(series2[j][0], series1[i][1] + series2[j][1])));
                i++;
                j++;
            }

        }
        while (i < n) {
            res.add(new ArrayList<>(Arrays.asList(series1[i][0], series1[i][1])));
            i++;
        }
        while (j < m) {
            res.add(new ArrayList<>(Arrays.asList(series2[j][0], series2[j][1])));
            j++;
        }
        return res;
    }
}