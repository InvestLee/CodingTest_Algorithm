import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
visited = [-1] * 100001 #방문 최소 시간 기록(순간이동이 0초 소모되므로 초기값 -1로 설정)

q = deque()
q.append(N)
visited[N] = 0
while q:
    subin = q.popleft()
    if subin == K:
        break
    if 0 < subin*2 < 100001 and visited[subin*2] == -1:
        q.appendleft(subin*2) #X+1, X-1보다 1초 앞서므로 appendleft
        visited[subin*2] = visited[subin]
    if subin+1 <= K and visited[subin+1] == -1:
        q.append(subin+1)
        visited[subin+1] = visited[subin] + 1
    if subin-1 >= 0 and visited[subin-1] == -1:
        q.append(subin-1)
        visited[subin-1] = visited[subin] + 1

print(visited[K])