import sys

N = int(sys.stdin.readline().rstrip())
num_list = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline().rstrip())
range_list = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]

# dp[시작][끝]
dp = [[0]*N for _ in range(N)]

#길이가 1인 경우 자기 자신은 펠린드롬
for i in range(N):
    dp[i][i] = 1

#길이가 2인 경우 바로 옆 num과 같을 경우 펠린드롬
for i in range(1,N):
    if num_list[i-1] == num_list[i]:
        dp[i-1][i] = 1

#길이가 3이상인 경우(i = 길이, j = 시작점)
for i in range(2,N):
    for j in range(N-i):
        #어떤 문자열이 팰린드롬이라면 그 문자열의 앞 뒤 num이 같으면 역시 팰린드롬
        if num_list[j] == num_list[i+j] and dp[j+1][i+j-1] == 1:
            dp[j][i+j] = 1

#팰린드롬 여부 출력
for start, end in range_list:
    print(dp[start-1][end-1])