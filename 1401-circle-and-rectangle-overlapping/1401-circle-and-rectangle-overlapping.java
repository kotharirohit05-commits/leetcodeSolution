class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int nearestX = 0;
        if(x1 > xCenter){
            nearestX = x1;
        }else if( xCenter > x2){
            nearestX = x2;
        }else{
            nearestX = xCenter;
        }

        int nearestY = 0;
        if(y1 > yCenter){
            nearestY = y1;
        }else if( yCenter > y2){
            nearestY = y2;
        }else{
            nearestY = yCenter;
        }

        double d = Math.sqrt((double)((xCenter - nearestX)  * (xCenter - nearestX)) 
         + ((double)(yCenter - nearestY)  *(yCenter - nearestY)));

         if( d <= radius ){
            return true;
         }

        return false;

    }
}