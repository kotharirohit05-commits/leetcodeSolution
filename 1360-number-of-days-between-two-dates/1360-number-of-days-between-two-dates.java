class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(df1971(date1) - df1971(date2));
    }
    private int df1971(String date){
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int months = Integer.parseInt(parts[1]);
        int days = Integer.parseInt(parts[2]);
        int[] daysinmonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int ttldays = 0;

        for(int y = 1971 ; y < year ; y++){
            ttldays += isLeap(y)? 366 : 365;
        }
        for(int m = 1 ; m < months ; m++){
            ttldays += daysinmonth[m-1];
            if(m == 2 && isLeap(year)){
                ttldays++;
            }
        }
        ttldays += days;
        return ttldays;
    }




        private boolean isLeap(int year){
            return((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        }
}
    

