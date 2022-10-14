import sys

#회전 방향 우회전순
dx = [1,0,-1,0]
dy = [0,-1,0,1]

n = int(sys.stdin.readline().rstrip())
command_list = list(str(sys.stdin.readline().rstrip()))
direction = 0 #방향 지시자 처음에는 남쪽

#위치 기록
move_xy = [[0,0]]

for c in command_list:
    if c == "R":
        direction = (direction+1) % 4
    elif c == "L":
        direction = (direction+3) % 4
    else:
        nx, ny = move_xy[-1] #현재 위치
        nx += dx[direction] #x이동
        ny += dy[direction] #y이동
        move_xy.append([nx,ny]) #현재 위치 기록

#출력할 지도 크기 설정
graph = list(zip(*move_xy))
x_range = max(graph[0])-min(graph[0])+1
x_add = abs(min(graph[0]))
y_range = max(graph[1])-min(graph[1])+1
y_add = abs(min(graph[1]))

#지도 그리기
result = [["#" for _ in range(y_range)] for _ in range(x_range)]
for x,y in move_xy:
    result[x+x_add][y+y_add] = "."

#출력
for r in result:
    print("".join(r))