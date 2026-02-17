class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int i = 0; 
        int c = 1;
        while( candies > 0){
            arr[ i % num_people] += Math.min(c,candies);
            candies -= c;
            i++;
            c++;
        }
        return arr;
    }
}