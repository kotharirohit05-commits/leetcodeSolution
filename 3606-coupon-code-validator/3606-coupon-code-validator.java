import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> order = Arrays.asList(
            "electronics",
            "grocery",
            "pharmacy",
            "restaurant"
        );

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i]) continue;
            if (!order.contains(businessLine[i])) continue;
            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("^[a-zA-Z0-9_]+$")) continue;

            valid.add(new String[]{businessLine[i], code[i]});
        }

        Collections.sort(valid, (a, b) -> {
            int cmp = order.indexOf(a[0]) - order.indexOf(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] c : valid) {
            result.add(c[1]);
        }

        return result;
    }
}
