import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
queue = deque()
while True:
    info = sys.stdin.readline().rstrip()
    if info == "-1": break
    elif info == "0": queue.popleft()
    elif len(queue) < n: queue.append(info)
if len(queue) == 0: print("empty")
else: print(" ".join(queue))