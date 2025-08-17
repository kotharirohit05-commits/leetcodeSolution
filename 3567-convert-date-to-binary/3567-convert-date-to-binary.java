class Solution {
    public String convertDateToBinary(String date) {
        String[] str = date.split("-");
        int n1 = Integer.valueOf(str[0]);
        int n2 = Integer.valueOf(str[1]);
        int n3 = Integer.valueOf(str[2]);

        String s1 = Integer.toBinaryString(n1);
        String s2 = Integer.toBinaryString(n2);
        String s3 = Integer.toBinaryString(n3);
        
        return s1 +"-" +s2+"-"+s3;

    }
}