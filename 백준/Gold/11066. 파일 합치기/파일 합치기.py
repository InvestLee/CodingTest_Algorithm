import sys
from itertools import accumulate

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    K = int(sys.stdin.readline().rstrip())
    num_list = list(map(int, sys.stdin.readline().split()))
    #누적합을 통한 시간복잡도 확보
    num_list = [0] + list(accumulate(num_list))
    
    #dp[시작점][끝점]
    dp = [[0]*(K+1) for _ in range(K+1)]
    for i in range(2,K+1): #구하고자 하는 구간의 길이
        for j in range(1,K+2-i): #시작점
            #시작점~(시작점+k)까지의 합, (시작점+k+1)~(끝점-1)까지의 합 중 최솟값 + (시작점~끝점-1) 합
            #ex. 2번부터 4번까지 최소합 min(dp[2][2]+dp[3][4], dp[2][3]+dp[4][4]) + (2~4까지 누적합)
            dp[j][j+i-1] = min([dp[j][j+k]+dp[j+k+1][j+i-1] for k in range(i-1)]) + num_list[j+i-1] - num_list[j-1]
    print(dp[1][K])