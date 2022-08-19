import sys

n, k = map(int, sys.stdin.readline().split())
coin = []
for _ in range(n):
    coin.append(int(sys.stdin.readline().rstrip()))
#dp 최대치 이상을 디폴트로 하여 가치의 합만큼 선언
dp=[10001]*(k+1)
#가치가 0은 0번
dp[0] = 0
#모든 코인
for c in coin:
    for i in range(c,k+1):
        #i원을 만들기 위해 dp[i-c]원에서 c코인을 더하는 경우와 비교
        dp[i] = min(dp[i],dp[i-c]+1)
if dp[-1] == 10001:print(-1)
else:print(dp[-1])