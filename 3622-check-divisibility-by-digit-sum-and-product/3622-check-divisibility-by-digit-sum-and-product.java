class Solution {
    public boolean checkDivisibility(int n) {
        int prod = 1;
        int sum = 0;
        int x = n;
        while(n > 0){
            int dig = n % 10;
            sum += dig;
            prod *= dig;
            n = n / 10;
        }
        System.out.println(sum);
        System.out.println(prod);
        int ttl = sum + prod;
        if(x % ttl != 0) return false;
        return true;
    }
}