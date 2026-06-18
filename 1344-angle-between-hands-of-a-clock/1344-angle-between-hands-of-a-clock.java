class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double big = (minutes  * 6);
        double small = (hour * 30) + (minutes) * 0.5;
        double diff = Math.abs(big - small);
        if(diff < 180){
            return diff;
        }else{
            return 360 - diff;
        }

    }
}