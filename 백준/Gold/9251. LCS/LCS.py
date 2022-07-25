import sys
'''
같은 알파벳인 경우 해당 위치에서 글자를 추가하기 전의 LCS 값보다 1을 더하고
다른 알파벳인 경우 이전 과정 들 중 가장 큰 숫자를 가져옴
\\CAPCAK
\0000000
A0111111
C0111222
A0122233
Y0122233
K0122234
P0123334
'''

S1 = sys.stdin.readline().rstrip()
S2 = sys.stdin.readline().rstrip()
#이전 단계를 쉽게 참조하기 위해 맨 앞에 공백 생성
dp = [[0 for _ in range(len(S2)+1)] for _ in range(len(S1)+1)]

for i in range(1,len(S1)+1):
    for j in range(1, len(S2)+1):
        if S1[i-1] == S2[j-1]:
            dp[i][j] = 1+dp[i-1][j-1] #같은 글자 발견 시 둘 다 다음 단계로 가므로
        else:
            dp[i][j] = max(dp[i-1][j],dp[i][j-1])
print(dp[-1][-1])