import sys
from collections import deque

gear = {}
for i in range(4):
    gear[i+1] = deque(list(map(int, sys.stdin.readline().rstrip())))
K = int(sys.stdin.readline().rstrip())
command_rotate = [list(map(int, sys.stdin.readline().split())) for _ in range(K)]
for g, r in command_rotate:
    #1번과 2번, 2번과 3번, 3번과 4번 연동 회전 여부
    rotate_true = [False] * 3
    for i in range(3):
        if gear[i+1][2] != gear[i+2][6]:
            rotate_true[i] = True
    #기어 회전
    gear[g].rotate(r)
    for i in range(g-1,3):
        if rotate_true[i]:gear[i+2].rotate(r*((-1)**(g-i+2)))
        else:break
    for i in range(g-2,-1,-1):
        if rotate_true[i]:gear[i+1].rotate(r*((-1)**(g-i+1)))
        else:break
result = 0
for i in range(1,5):
    if gear[i][0] == 1:
        result += 2**(i-1)
print(result)
