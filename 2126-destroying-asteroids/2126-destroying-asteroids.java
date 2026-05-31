class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long neww = mass;
        for(int i = 0 ; i < asteroids.length ; i++){
            if(neww >= asteroids[i]){
                neww += asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}