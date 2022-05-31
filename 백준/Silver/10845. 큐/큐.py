import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
queue = deque([])
for _ in range(N):
    Command_queue = list(map(str,sys.stdin.readline().split()))
    if Command_queue[0] == "push":
        queue.append(int(Command_queue[1]))
    elif Command_queue[0] == "pop":
        if len(queue) == 0: print(-1)
        else: print(queue.popleft())
    elif Command_queue[0] == "size":
        print(len(queue))
    elif Command_queue[0] == "empty":
        if len(queue) == 0: print(1)
        else: print(0)
    elif Command_queue[0] == "front":
        if len(queue) == 0: print(-1)
        else: print(queue[0])
    else:
        if len(queue) == 0: print(-1)
        else: print(queue[-1])
