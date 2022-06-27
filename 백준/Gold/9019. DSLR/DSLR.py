import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    start, result = map(int, sys.stdin.readline().split())
    #같은 숫자 연산을 방지하기 위한 방문 처리
    visited = [False] * 10000
    #bfs
    queue = deque()
    queue.append((start,""))
    while queue:
        next_num, command_str = queue.popleft()
        if visited[next_num] == True:
            continue
        visited[next_num] = True
        #정답 시 출력 후 bfs 종료
        if next_num == result:
            print(command_str)
            break
        #D 명령어
        queue.append(((next_num*2)%10000,command_str+"D"))
        #S 명령어
        if next_num == 0:
            queue.append((9999,command_str+"S"))
        else:
            queue.append((next_num-1,command_str+"S"))
        #L 명령어(레지스터 방식으로 저장되어 있으므로 아래 식이 성립)
        #next_num*10 -> 자릿수 상승, next_num//1000 -> 천의 자리를 일의 자리로
        queue.append(((next_num*10+(next_num//1000))%10000,command_str+"L"))
        #R 명령어
        #next_num//10 -> 자릿수 감소, (next_num%10)*1000 -> 일의 자리를 천의 자리로 
        queue.append(((next_num//10+(next_num%10)*1000)%10000,command_str+"R"))