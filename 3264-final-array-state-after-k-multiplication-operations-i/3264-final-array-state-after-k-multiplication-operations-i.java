class Pair implements Comparable<Pair>{

    int element;
    int index;

    public Pair(int element , int index){
        this.element = element;
        this.index = index;
    }

    public int compareTo(Pair that){
        if(this.element == that.element){
            return Integer.compare(this.index, that.index);
        }
        return Integer.compare(this.element, that.element);
    }
}


class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int count = 0 ;
        PriorityQueue<Pair> minh = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ; i++){
            Pair cur = new Pair(nums[i] ,i);
            minh.offer(cur);
        }

        while(k > 0){

            Pair s = minh.poll();
            int element = s.element;
            int index = s.index;
            element *= multiplier;
            minh.offer(new Pair(element,index));
            k--;
        }
        int[] arr = new int[nums.length];
        while(!minh.isEmpty()){
            Pair s = minh.poll();
            int element = s.element;
            int index = s.index;

            arr[index] = element; 
        }
        return arr;

    }
}