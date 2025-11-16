class Solution {
    public int countOperations(int num1, int num2) {
        int operations = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                // Instead of subtracting 1 time, do it in bulk
                operations += num1 / num2;
                num1 = num1 % num2;
            } else {
                operations += num2 / num1;
                num2 = num2 % num1;
            }
        }

        return operations;
    }
}