class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int cnt=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }else{
                ans+=cnt;
                while(i<n-1&&s.charAt(i+1)=='0'){
                    i++;
                }
            }
        }
        return ans;
    }
}