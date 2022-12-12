def solution(n):
    if n == 1:
        return 1
    if n == 2:
        return 2

    dp = [0 for i in range(n+1)]
    dp[1], dp[2] = 1, 2

    for i in range(3, n+1):
        dp[i] = (dp[i-1] + dp[i-2])%1234567

    return dp[n]%1234567