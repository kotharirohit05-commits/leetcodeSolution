import java.util.Arrays;

public class Solution {
    public double[] internalAngles(int[] sides) {
        // Step 1: Sort the array to easily check the triangle inequality
        Arrays.sort(sides);
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        
        // Triangle inequality check (after sorting, a + b > c must hold)
        if (a + b <= c) {
            return new double[0]; // Returns an empty array []
        }
        
        // Step 2 & 3: Law of Cosines to calculate angles in degrees
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double cosB = (a * a + c * c - b * b) / (2 * a * c);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        
        // Clamp values to the [-1.0, 1.0] range to prevent Math.acos from returning NaN
        cosA = Math.max(-1.0, Math.min(1.0, cosA));
        cosB = Math.max(-1.0, Math.min(1.0, cosB));
        cosC = Math.max(-1.0, Math.min(1.0, cosC));
        
        double A = Math.toDegrees(Math.acos(cosA));
        double B = Math.toDegrees(Math.acos(cosB));
        double C = Math.toDegrees(Math.acos(cosC));
        
        // Step 4: Sort and return the angles
        double[] angles = {A, B, C};
        Arrays.sort(angles);
        
        return angles;
    }
}
