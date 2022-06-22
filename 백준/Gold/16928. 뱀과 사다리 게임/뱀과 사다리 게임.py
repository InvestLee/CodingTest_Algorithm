import sys
from collections import deque

#입력단(사다리 및 뱀 정보는 접근이 빠른 딕셔너리 형태로 지정)
N, M = map(int, sys.stdin.readline().split())
ladder = {}
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    ladder[x] = y
snake = {}
for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    snake[u] = v
#한번 갔던 곳을 다시 가면 최소 이동 수가 아니므로 방문 처리
visited = [False] * 101
#1이랑 100도 방문처리해야 하므로 횟수와 분리
cnt = [0] * 101

#bfs
queue = deque([1])
visited[1] = True
while queue:
    now_location = queue.popleft()
    #너비우선탐색이므로 원하는 위치가 오면 바로 bfs 종료
    if now_location == 100:
        break
    #주사위는 1부터 6까지 나올 수 있음
    for dice in range(1,7):
        next_location = now_location + dice
        #1번 칸을 제외하고 방문 처리가 0이 아닌 경우는 이미 방문한 경우
        if next_location > 100 or visited[next_location]:
            continue
        #사다리나 뱀인 경우 그것을 타기 전 위치도 방문처리 해줘야 됨
        if next_location in ladder:
            visited[next_location] = True
            next_location = ladder[next_location]
        if next_location in snake:
            visited[next_location] = True
            next_location = snake[next_location]
        #사다리와 뱀에 의해 next_location이 바꼈으므로 한번 더 방문 처리
        if not visited[next_location]:
            visited[next_location] = True
            cnt[next_location] = cnt[now_location] + 1
            queue.append(next_location)
print(cnt[100])