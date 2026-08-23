class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumLeft = 0, sumRight = 0;
        int qLeft = 0, qRight = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (i < n / 2) {
                if (ch == '?') {
                    qLeft++;
                } else {
                    sumLeft += ch - '0';
                }
            } else {
                if (ch == '?') {
                    qRight++;
                } else {
                    sumRight += ch - '0';
                }
            }
        }
        
        return 2 * (sumLeft - sumRight) != 9 * (qRight - qLeft);
    }
}
