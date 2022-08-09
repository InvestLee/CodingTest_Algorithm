import sys

N = int(sys.stdin.readline().rstrip())
student = [list(map(int, sys.stdin.readline().split())) for _ in range(N**2)]
student_dict = {}
for s in student:
    student_dict[s[0]] = set([s[i] for i in range(1,5)])
graph = [[0] * N for _ in range(N)]

dx = [-1,0,0,1]
dy = [0,-1,1,0]

#학생 자리 지정 함수
def like_count_location(s):
    max_like_count = 0
    max_empty_count = 0
    x, y = 0, 0
    ax, ay = -1, -1
    for i in range(N):
        for j in range(N):
            #이미 자리 배정되어있으면 패스
            if graph[i][j] != 0:
                continue
            like_count = 0
            empty_count = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if nx < 0 or ny < 0 or nx >= N or ny >= N:
                    continue
                #1번 조건
                if graph[nx][ny] in student_dict[s]:
                    like_count += 1
                #2번 조건
                if graph[nx][ny] == 0:
                    empty_count += 1
            if max_like_count < like_count or (max_like_count==like_count and max_empty_count < empty_count):
                max_like_count = like_count
                max_empty_count = empty_count
                x, y = i, j
            if max_like_count == 0 and max_empty_count == 0 and ax == -1 and ay == -1:
                ax, ay = i, j
    if max_like_count == 0 and max_empty_count == 0:
        x, y = ax, ay
    return x, y, max_like_count, max_empty_count

#학생 자리 입력
for s in student_dict.keys():
    x, y = like_count_location(s)[0], like_count_location(s)[1]
    graph[x][y] = s

#만족도 계산
result = 0
for i in range(len(graph)):
    for j in range(len(graph[0])):
        like_count = 0
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if graph[nx][ny] in student_dict[graph[i][j]]:
                like_count += 1
        if like_count == 0:
            continue
        else:
            result += (10 ** (like_count-1))

print(result)