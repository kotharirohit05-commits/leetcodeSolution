class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] mos = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] alice = new int[366];
        int[] bob = new int[366];

        int alicearrivalmonth = Integer.parseInt(arriveAlice.substring(0,2));
        int bobarrivalmonth = Integer.parseInt(arriveBob.substring(0,2));

        int alicedeptmonth = Integer.parseInt(leaveAlice.substring(0,2));
        int bobdeptmonth = Integer.parseInt(leaveBob.substring(0,2));

        int alicearrivalday = Integer.parseInt(arriveAlice.substring(3,arriveAlice.length()));

        int bobarrivalday = Integer.parseInt(arriveBob.substring(3,arriveBob.length()));

        int alicedeptday = Integer.parseInt(leaveAlice.substring(3,arriveAlice.length()));

        int bobdeptday = Integer.parseInt(leaveBob.substring(3,arriveBob.length()));

        int fda = 0;
        for(int i = 0; i < alicearrivalmonth - 1; i++){
            fda += mos[i];
        }
        fda += alicearrivalday;

        int lda = 0;
        for(int i = 0; i < alicedeptmonth - 1; i++){
            lda += mos[i];
        }
        lda += alicedeptday;

        int fdb = 0;
        for(int i = 0; i < bobarrivalmonth - 1; i++){
            fdb += mos[i];
        }
        fdb += bobarrivalday;

        int ldb = 0;
        for(int i = 0; i < bobdeptmonth - 1; i++){
            ldb += mos[i];
        }
        ldb += bobdeptday;

        

        for(int i = fda; i <= lda; i++){
            alice[i] = 1;
        }
        for(int i = fdb; i <= ldb; i++){
            bob[i] = 1;
        }
        int count = 0;
        for(int i = 0; i <= 365; i++){
            if(alice[i] == 1 && bob[i] == 1){
                count++;
            }
        }

        


        return count;
        
    }
}