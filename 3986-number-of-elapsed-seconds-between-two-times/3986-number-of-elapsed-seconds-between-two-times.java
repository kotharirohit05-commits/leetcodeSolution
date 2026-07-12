class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int anss = 0;
        int anse = 0;
        int hrs = Integer.parseInt(startTime.substring(0,2));
        int hre = Integer.parseInt(endTime.substring(0,2));
        anss += hrs * 60 * 60;
        anse += hre * 60 * 60;
    
        
        int hms = Integer.parseInt(startTime.substring(3,5));
        int hme = Integer.parseInt(endTime.substring(3,5));
        anss += hms * 60;
        anse += hme * 60;
        

        int hss = Integer.parseInt(startTime.substring(6,8));
        int hse = Integer.parseInt(endTime.substring(6,8));
        anss += hss;
        anse += hse;

        return anse - anss;

    }
}