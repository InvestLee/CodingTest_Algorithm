import sys
from collections import deque

N, K = map(int,sys.stdin.readline().split())
queue = deque([i+1 for i in range(N)]) #큐를 통해 요세푸스 구현

count = 0 #>로 닫을지 ,로 이어갈지 판단
print("<",end="")
while queue:
    for i in range(K-1):
        queue.append(queue.popleft())
    if count == N-1:
        print(queue.popleft(),end=">")
    else:
        print(queue.popleft(),end=", ")
    count += 1