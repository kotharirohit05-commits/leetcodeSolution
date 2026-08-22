class Solution {

    private List<Integer> generator(int r){
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans);
        
        for(int i = 1; i < r; i++){
            ans = ans * (r - i);
            ans = ans / i;
            temp.add(ans);
        }
        return temp;
        
    }

    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            res.add(generator(i));
        }
        return res;


    }
}