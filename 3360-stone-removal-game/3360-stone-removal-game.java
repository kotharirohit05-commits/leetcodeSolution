class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        int forAlice = 10;
        int forBob = 9;
        boolean isAlicePicking = true;
        while( n  > 0){
            if(isAlicePicking == true){
                if( n < forAlice) return false;
                n = n - forAlice;
                forAlice = forAlice - 2;
                isAlicePicking = !isAlicePicking;
                if(n < forBob){
                    return true;
                }
            }else{
                n = n - forBob;
                forBob = forBob - 2;
                isAlicePicking = !isAlicePicking;
            }
        }
        return false;

    }
}