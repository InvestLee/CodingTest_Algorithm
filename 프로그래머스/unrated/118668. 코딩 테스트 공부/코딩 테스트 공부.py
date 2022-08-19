def solution(alp, cop, problems):
    temp = list(zip(*problems))
    max_alp = max(alp, max(temp[0]))
    max_cop = max(cop, max(temp[1]))
    dp = [[int(1e9)] * (max_cop+2) for _ in range(max_alp+2)]
    dp[alp][cop] = 0
    for i in range(alp,max_alp+1):
        for j in range(cop,max_cop+1):
            dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1)
            dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1)
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req:
                    if i+alp_rwd > max_alp and j+cop_rwd > max_cop:
                        dp[max_alp][max_cop] = min(dp[max_alp][max_cop], dp[i][j]+cost)
                    elif i+alp_rwd > max_alp:
                        dp[max_alp][j+cop_rwd] = min(dp[max_alp][j+cop_rwd], dp[i][j]+cost)
                    elif j+cop_rwd > max_cop:
                        dp[i+alp_rwd][max_cop] = min(dp[i+alp_rwd][max_cop], dp[i][j]+cost)
                    elif i+alp_rwd <= max_alp and j+cop_rwd <= max_cop:
                        dp[i+alp_rwd][j+cop_rwd] = min(dp[i+alp_rwd][j+cop_rwd], dp[i][j]+cost)
    return dp[max_alp][max_cop]