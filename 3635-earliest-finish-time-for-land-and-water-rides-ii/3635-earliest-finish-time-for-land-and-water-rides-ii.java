class Solution {
    public int earliestFinishTime(int[] LST, int[] LD, int[] WST, int[] WD) {

        int landStart = (int)1e9+7;
        int waterStart = (int)1e9+7;
        int n1 = LD.length;
        int n2 = WD.length;

        for(int i = 0 ; i < n1 ; i++){

            landStart = Math.min(landStart , LST[i] + LD[i]);

        }

         for(int i = 0 ; i < n2; i++){

            waterStart = Math.min(waterStart, WST[i] + WD[i]);

        }

       

        int min1 = (int)1e9;
        int min2 = (int)1e9;

        
        for(int i = 0 ; i < n2 ; i++){

            int curStartTime = WST[i];

            if(curStartTime <= landStart){
                int curAns = landStart + WD[i];
                min1 = Math.min(curAns , min1);
            }else{
                int curAns = WST[i]  + WD[i];
                min1 = Math.min(curAns , min1);
            }

        }

        for(int i = 0 ; i < n1 ; i++){

            int curStartTime = LST[i];

            if(curStartTime <= waterStart){
                int curAns = waterStart + LD[i];
                min2 = Math.min(curAns , min2);
            }else{
                int curAns = LST[i] + LD[i];
                min2 = Math.min(curAns , min2);
            }

        }
        
        // System.out.println(min1 + " " + min2);

        return Math.min(min1 , min2);




        
    }
}