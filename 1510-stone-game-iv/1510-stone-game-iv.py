class Solution(object):
    def winnerSquareGame(self, n):
        """
        :type n: int
        :rtype: bool
        """
        # dp[i] represents if the player whose turn it is can win with i stones remaining
        dp = [False] * (n + 1)
        
        # Iterate through all stone states from 1 to n
        for i in range(1, n + 1):
            j = 1
            # Check every valid perfect square move
            while j * j <= i:
                # If removing j*j stones forces the opponent into a losing state, 
                # the current player wins.
                if not dp[i - j * j]:
                    dp[i] = True
                    break  # No need to check other moves for this state
                j += 1
                
        return dp[n]
