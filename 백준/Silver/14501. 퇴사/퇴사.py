import sys

N = int(sys.stdin.readline().rstrip())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [0] * (N+1) # N+1일 전까지 금액을 합산

#N일을 넘기지 않기 위해 역순으로 진행
#해당 날짜의 일을 맡았을 경우(해당 날짜 work후 다음 work까지의 합, 해당 날짜의 일 합) 
# vs 해당 날짜의 일을 안맡았을 때 그 전까지의 합
for i in range(N-1,-1,-1):
    if i + arr[i][0] > N:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(arr[i][1]+dp[i+arr[i][0]],dp[i+1]) #점화식

print(dp[0])