import sys

#동적계획법

N = int(sys.stdin.readline().rstrip())
dp = [0] * (N+1)
dp[0], dp[1] = 0, 1 #1의 제곱수의 최소 갯수는 1
for i in range(2,N+1): #2부터 N까지 각 최소 제곱수 동적계획법
    j = 1 #제곱수의 초기값
    min_Qty = 4 #제곱수의 갯수는 4개를 초과하지 않으므로 초기값 4 설정
    while j**2<=i: #구하고자하는 숫자보다 작거나 같은 제곱수
        min_Qty = min(min_Qty,dp[i-(j**2)]) #j**2를 더하기 전까지의 최소값 판별
        j+=1
    dp[i] = min_Qty+1 #j**2를 더한 값
print(dp[N])