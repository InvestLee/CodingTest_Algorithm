import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
queue = deque([i+1 for i in range(N)])
while len(queue)>1:
    queue.popleft()
    queue.append(queue.popleft())
print(queue.pop())