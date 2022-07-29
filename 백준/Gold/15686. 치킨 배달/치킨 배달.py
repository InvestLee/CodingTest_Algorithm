import sys
N, M = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

min_result = int(1e9)

#집 위치 및 치킨 집 위치
house = []
chicken = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            house.append((i,j))
        elif graph[i][j] == 2:
            chicken.append((i,j))

#도시의 치킨 거리가 가장 작게 되게 고르는 함수
select_chicken = []
def backtracking(start,count):
    global min_result
    #총 치킨 거리 도출
    if count == M:
        total_Distance = 0
        for hx, hy in house:
            Distance = int(1e9)
            for cx, cy in select_chicken:
                Distance = min(Distance,abs(hx-cx)+abs(hy-cy))
            total_Distance += Distance
        min_result = min(min_result, total_Distance)
        return
    #치킨 집 선택
    for i in range(start,len(chicken)):
        select_chicken.append(chicken[i])
        backtracking(i+1,count+1)
        select_chicken.pop()

backtracking(0,0)
print(min_result)