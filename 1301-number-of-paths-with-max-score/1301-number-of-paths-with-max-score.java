class Solution {
    int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        // dpScore[i][j] = maximum score from (i,j) to S
        int[][] dpScore = new int[n][n];

        // dpWays[i][j] = number of maximum-score paths
        int[][] dpWays = new int[n][n];

        // -1 means unreachable
        for (int i = 0; i < n; i++) {
            Arrays.fill(dpScore[i], -1);
        }

        // Base case: Start (S)
        dpScore[n - 1][n - 1] = 0;
        dpWays[n - 1][n - 1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                int best = -1;
                int ways = 0;

                // Down
                if (i + 1 < n && dpScore[i + 1][j] != -1) {
                    if (dpScore[i + 1][j] > best) {
                        best = dpScore[i + 1][j];
                        ways = dpWays[i + 1][j];
                    } else if (dpScore[i + 1][j] == best) {
                        ways = (ways + dpWays[i + 1][j]) % MOD;
                    }
                }

                // Right
                if (j + 1 < n && dpScore[i][j + 1] != -1) {
                    if (dpScore[i][j + 1] > best) {
                        best = dpScore[i][j + 1];
                        ways = dpWays[i][j + 1];
                    } else if (dpScore[i][j + 1] == best) {
                        ways = (ways + dpWays[i][j + 1]) % MOD;
                    }
                }

                // Diagonal
                if (i + 1 < n && j + 1 < n && dpScore[i + 1][j + 1] != -1) {
                    if (dpScore[i + 1][j + 1] > best) {
                        best = dpScore[i + 1][j + 1];
                        ways = dpWays[i + 1][j + 1];
                    } else if (dpScore[i + 1][j + 1] == best) {
                        ways = (ways + dpWays[i + 1][j + 1]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                int value = 0;
                if (ch >= '1' && ch <= '9')
                    value = ch - '0';

                dpScore[i][j] = best + value;
                dpWays[i][j] = ways;
            }
        }

        if (dpWays[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{dpScore[0][0], dpWays[0][0]};
    }
}