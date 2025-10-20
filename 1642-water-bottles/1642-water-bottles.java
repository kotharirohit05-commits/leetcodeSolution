class Solution {
    public int numWaterBottles(int nb, int ne) {
        int ttl = nb ;
        int empty = nb ;
        while(empty >= ne){
            int newb = empty / ne;
            ttl += newb;
            empty = newb + (empty % ne);
        }
        return ttl;
    }
}