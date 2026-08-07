import java.util.Arrays;

public class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Extract prime factors of t (only 2, 3, 5, 7 are allowed)
        long tempT = t;
        int req2 = 0, req3 = 0, req5 = 0, req7 = 0;
        
        while (tempT % 2 == 0) { req2++; tempT /= 2; }
        while (tempT % 3 == 0) { req3++; tempT /= 3; }
        while (tempT % 5 == 0) { req5++; tempT /= 5; }
        while (tempT % 7 == 0) { req7++; tempT /= 7; }
        
        // If t has prime factors other than 2, 3, 5, 7, it's impossible
        if (tempT > 1) {
            return "-1";
        }
        
        int n = num.length();
        int[] digits = new int[n];
        int firstZeroIdx = -1;
        for (int i = 0; i < n; i++) {
            digits[i] = num.charAt(i) - '0';
            if (digits[i] == 0 && firstZeroIdx == -1) {
                firstZeroIdx = i;
            }
        }
        
        // Track the requirements after each prefix position
        int[][] req = new int[n + 1][4];
        req[0] = new int[]{req2, req3, req5, req7};
        
        for (int i = 0; i < n; i++) {
            req[i + 1] = reduce(req[i], digits[i]);
        }
        
        // Check if the current number is already valid and zero-free
        if (firstZeroIdx == -1 && isSatisfied(req[n])) {
            return num;
        }
        
        // Step 2: Try to find the longest common prefix by scanning from right to left
        // We can only deviate at index i if there are no zeros before index i
        int maxPrefixLimit = (firstZeroIdx == -1) ? n - 1 : firstZeroIdx;
        
        for (int i = maxPrefixLimit; i >= 0; i--) {
            int startDigit = digits[i] + 1;
            for (int d = startDigit; d <= 9; d++) {
                int[] nextReq = reduce(req[i], d);
                int remLen = n - 1 - i;
                
                if (minDigitsNeeded(nextReq) <= remLen) {
                    // Construct the result of the same length
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        sb.append(digits[j]);
                    }
                    sb.append(d);
                    
                    // Fill the remaining suffix greedily with the smallest possible digits
                    int[] currentReq = nextReq;
                    for (int j = i + 1; j < n; j++) {
                        for (int nextD = 1; nextD <= 9; nextD++) {
                            int[] candReq = reduce(currentReq, nextD);
                            if (minDigitsNeeded(candReq) <= n - 1 - j) {
                                sb.append(nextD);
                                currentReq = candReq;
                                break;
                            }
                        }
                    }
                    return sb.toString();
                }
            }
        }
        
        // Step 3: If no number of the same length works, expand to a larger length
        int targetLen = n + 1;
        int[] baseReq = {req2, req3, req5, req7};
        while (minDigitsNeeded(baseReq) > targetLen) {
            targetLen++;
        }
        
        // Build the smallest valid number of length targetLen
        StringBuilder sb = new StringBuilder();
        int[] currentReq = baseReq;
        for (int i = 0; i < targetLen; i++) {
            for (int d = 1; d <= 9; d++) {
                int[] candReq = reduce(currentReq, d);
                if (minDigitsNeeded(candReq) <= targetLen - 1 - i) {
                    sb.append(d);
                    currentReq = candReq;
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    // Reduces the required prime factors based on the chosen digit
    private int[] reduce(int[] currentReq, int d) {
        int c2 = currentReq[0], c3 = currentReq[1], c5 = currentReq[2], c7 = currentReq[3];
        if (d == 2) { c2--; }
        else if (d == 3) { c3--; }
        else if (d == 4) { c2 -= 2; }
        else if (d == 5) { c5--; }
        else if (d == 6) { c2--; c3--; }
        else if (d == 7) { c7--; }
        else if (d == 8) { c2 -= 3; }
        else if (d == 9) { c3 -= 2; }
        return new int[]{Math.max(0, c2), Math.max(0, c3), Math.max(0, c5), Math.max(0, c7)};
    }
    
    private boolean isSatisfied(int[] req) {
        return req[0] == 0 && req[1] == 0 && req[2] == 0 && req[3] == 0;
    }
    
    // Computes the absolute minimum number of single digits needed to satisfy the prime requirements
    private int minDigitsNeeded(int[] req) {
        int c2 = req[0], c3 = req[1], c5 = req[2], c7 = req[3];
        int count = c5 + c7;
        
        int n9 = c3 / 2;
        int r3 = c3 % 2;
        
        int n8 = c2 / 3;
        int r2 = c2 % 3;
        
        if (r3 == 1 && r2 > 0) {
            count += 1; // Form a 6
            r3--;
            r2--;
        }
        
        count += n9 + r3 + n8 + (r2 + 1) / 2;
        return count;
    }
}
