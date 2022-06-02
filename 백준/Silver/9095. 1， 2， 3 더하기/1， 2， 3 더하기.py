import sys

dp = [0] * 11
dp[1] = 1
dp[2] = 2
dp[3] = 4
for i in range(4,11):
    dp[i] = dp[i-3]+dp[i-2]+dp[i-1] #점화식

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    print(dp[n])

# 점화식 도출 사유 예시
# dp[5]를 만들 수 있는 경우의 수 =
# +dp[2]의 요소들에 +3을 더하면 dp[5]의 원소
# +dp[3]의 요소들에 +2를 더하면 dp[5]의 원소
# +dp[4]의 요소들에 +1를 더하면 dp[5]의 원소
# 더할 수 있는 요소가 1, 2, 3뿐 이므로 점화식 도출 가능 