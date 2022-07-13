import sys

#입력단
N = int(sys.stdin.readline().rstrip())
color_cost = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

#현재의 집의 색깔을 가정 후 가능한 이전 집들의 비용 중 최솟값을 계속 더하는 방식으로 진행
for i in range(1,N):
    color_cost[i][0] += min(color_cost[i-1][1],color_cost[i-1][2])
    color_cost[i][1] += min(color_cost[i-1][0],color_cost[i-1][2])
    color_cost[i][2] += min(color_cost[i-1][0],color_cost[i-1][1])
print(min(color_cost[N-1]))
