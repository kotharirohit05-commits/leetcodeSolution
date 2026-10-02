class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

       

        helper(res, 0, sb, n, 0, 0);
        return res;

    }

    private void helper(List<String> list, int idx, StringBuilder sb, int n, int open, int close) {

        if (idx == 2 * n) {

            list.add(sb.toString());

            return;
        }

        if (open < n) {
            sb.append("(");
            helper(list, idx + 1, sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            helper(list, idx + 1, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}