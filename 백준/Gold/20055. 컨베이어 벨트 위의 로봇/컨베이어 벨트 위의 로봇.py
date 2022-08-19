import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
belt = list(map(int, sys.stdin.readline().split()))
belt_q = deque(belt)
robot_q = deque([0 for _ in range(N)])
phase = 0
while True:
    #벨트 회전
    belt_q.rotate(1)
    robot_q.rotate(1)
    #로봇 내리기
    robot_q[-1] = 0
    #가장 먼저 올라온 로봇부터 이동
    for i in range(N-1,0,-1):
        if belt_q[i] >= 1 and (robot_q[i-1] == 1 and robot_q[i] == 0):
            belt_q[i] -= 1
            robot_q[i] = 1
            robot_q[i-1] = 0
    #로봇 내리기
    robot_q[-1] = 0
    #로봇 올리기
    if belt_q[0] >= 1 and robot_q[0] == 0:
        belt_q[0] -= 1
        robot_q[0] = 1
    phase += 1
    #내구도 체크
    if belt_q.count(0) >= K:
        break
print(phase)