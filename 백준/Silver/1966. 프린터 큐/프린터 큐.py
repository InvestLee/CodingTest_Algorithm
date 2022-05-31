import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    paper = deque(list(map(int, sys.stdin.readline().split()))) #문서의 중요도
    location = deque([i for i in range(N)]) #각 문서의 위치
    count = 0 #인쇄되는 횟수
    while paper:
        p = paper.popleft()
        l = location.popleft()
        if len(paper) == 0 or p >= max(paper): #인쇄조건
            count += 1
            if l == M: #해당 문서 위치가 일치할 경우
                print(count) #몇번 인쇄되었는지 출력
        else:
            paper.append(p)
            location.append(l)