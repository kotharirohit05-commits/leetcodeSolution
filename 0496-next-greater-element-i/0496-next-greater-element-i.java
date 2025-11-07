class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap <Integer , Integer>  hs= new HashMap<>();
        
        int idx = 0;
        for(int i = nums2.length -1 ; i >= 0 ; i--){
            int num = nums2[i];
            while(!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                hs.put(num , -1);
            }else{
                hs.put(num , stack.peek());
            }
            stack.push(num);
        }
        int[] arr = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            arr[i] = hs.get(nums1[i]);
        }
        return arr;

    }
}