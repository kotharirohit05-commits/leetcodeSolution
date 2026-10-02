class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(res, 0, sb, n);
        return res;

    }

    private void helper(List<String> list, int idx, StringBuilder sb, int n) {

        if (idx == 2 * n) {
            if (isValid(sb.toString())) {
                list.add(sb.toString());
            }
            return;
        }

        sb.append("(");
        helper(list, idx + 1,sb, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        helper(list, idx + 1,sb, n);
        sb.deleteCharAt(sb.length() - 1);

    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;

    }

}