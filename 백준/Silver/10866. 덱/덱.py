import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
Deque = deque(())
for _ in range(N):
    command = list(map(str, sys.stdin.readline().split()))
    if command[0] == 'push_front':
        Deque.appendleft(int(command[1]))
    elif command[0] == 'push_back':
        Deque.append(int(command[1]))
    elif command[0] == 'pop_front':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque.popleft())
    elif command[0] == 'pop_back':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque.pop())
    elif command[0] == 'size':
        print(len(Deque))
    elif command[0] == 'empty':
        if len(Deque) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == 'front':
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[0])
    else:
        if len(Deque) == 0:
            print(-1)
        else:
            print(Deque[len(Deque)-1])