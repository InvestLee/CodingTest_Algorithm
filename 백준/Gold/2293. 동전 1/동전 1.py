import sys

#먼저 가장 작은 숫자로만 구성된 메모리제이션을 만든 뒤
#가장 작은 숫자로 구성된 리스트에 다음 숫자를 하나씩 입력할 때 만족하는 수에도 계속 횟수를 더해간다.

n, k = map(int, sys.stdin.readline().split())
coin = list(int(sys.stdin.readline().rstrip()) for i in range(n))
dp = [0 for i in range(k+1)]
dp[0] = 1 #dp[가장 작은 값]에 1을 넣기 위함
for i in coin:
    for j in range(1,k+1):
        if j-i >= 0: #동전보다 수가 클떄
            dp[j] += dp[j-i] #동전 차이만큼
print(dp[k])