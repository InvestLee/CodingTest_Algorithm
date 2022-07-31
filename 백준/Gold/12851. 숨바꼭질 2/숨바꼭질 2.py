import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
q = deque()
q.append((N,0))
visited = [False for _ in range(100001)] #메모리 용량을 고려한 방문처리
visited[N] = True
fastest = -1
count = 0
while q:
    now, t = q.popleft()
    visited[now] = True #여기 위치에서 선언해야 가장 빠른 경우 전부 반영
    #범위에 벗어나거나 가장 빠른 시간이 정해졌을 때 가장 빠른 시간보다 오래 걸리는 경우는 무시
    if now < 0 or now > 100000 or (fastest != -1 and fastest < t):
        continue
    if now == K:
        fastest = t
        count += 1
    if 0 <= now+1 < 100001 and not visited[now+1]:
        q.append((now+1,t+1))
    if 0 <= now-1 < 100001 and not visited[now-1]:
        q.append((now-1,t+1))
    if 0 <= now*2 < 100001 and not visited[now*2]:
        q.append((now*2,t+1))
print(fastest)
print(count)