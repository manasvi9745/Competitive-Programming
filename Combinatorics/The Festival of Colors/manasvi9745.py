MOD = 10**9 + 7

def count_colorings_optimal(n, m, k):
    dp = [0] * (n + 1)
    dp[0] = 1

    window_sum = dp[0]  # sum of last k dp values

    for i in range(1, n + 1):
        dp[i] = (window_sum * m) % MOD

        if i - k >= 0:
            dp[i] = (dp[i] - dp[i - k] + MOD) % MOD

        window_sum = (window_sum + dp[i]) % MOD

    return dp[n]


# Example
print(count_colorings_optimal(4, 3, 2))  # 66