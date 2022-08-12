import sys

N, M, K = map(int, sys.stdin.readline().split())
fireball = []
for _ in range(M):
    r, c, m, s, d = map(int, sys.stdin.readline().split())
    fireball.append([r-1, c-1, m, s, d])


#방향
dx = [-1,-1,0,1,1,1,0,-1]
dy = [0,1,1,1,0,-1,-1,-1]

graph = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(K):
    #파이어볼 이동
    while fireball:
        fr, fc, fm, fs, fd = fireball.pop()
        nx = (fr+dx[fd]*fs+N*fs) % N
        ny = (fc+dy[fd]*fs+N*fs) % N
        graph[nx][ny].append([fm, fs, fd])
    #2개 이상의 파이어볼 작업
    for i in range(N):
        for j in range(N):
            if len(graph[i][j]) > 1:
                sum_m, sum_s, odd, even, cnt = 0, 0, 0, 0, len(graph[i][j])
                while graph[i][j]:
                    sm, ss, sd = graph[i][j].pop()
                    sum_m += sm
                    sum_s += ss
                    if sd % 2 == 0:
                        even += 1
                    else:
                        odd += 1
                #합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수여부 판단
                if even == cnt or odd == cnt:
                    for k in range(0,7,2):
                        if sum_m//5: #질량 0이면 소멸
                            fireball.append([i, j, sum_m//5, sum_s//cnt, k])
                else:
                    for k in range(1,8,2):
                        if sum_m//5: #질량 0이면 소멸
                            fireball.append([i, j, sum_m//5, sum_s//cnt, k])
            #1개의 파이어볼인 경우
            if len(graph[i][j]) == 1:
                fireball.append([i, j]+graph[i][j].pop())


fireball = list(zip(*fireball))
if len(fireball) == 0:
    print(0)
else:
    print(sum(fireball[2]))