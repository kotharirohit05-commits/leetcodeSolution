class BusBooking {

        private int[][] matrix;
        private int ttltime;
        private int mintime;

    public BusBooking(int n) {
        
        matrix = new int[n][4];
        ttltime = 0;
        mintime = 0;

    }
    
    public void toggle(String seat) {
        int col = seat.charAt(0) - 'A';
        int row = Integer.parseInt(seat.substring(1)) - 1;
        
        
        if(matrix[row][col] == 0){
            int cost = 1;
            if (col == 0 && matrix[row][1] == 1) cost = 3;    
            else if (col == 3 && matrix[row][2] == 1) cost = 3; 
            
            matrix[row][col] = cost;
            ttltime += cost;
            mintime += 1;
        }
        else {
            ttltime -= matrix[row][col];
            matrix[row][col] = 0;
            mintime -= 1;
        }
    }
    
    public int getTotalTime() {

        return ttltime;
        
    }
    
    public int getMinTime() {

        return mintime;
        
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */