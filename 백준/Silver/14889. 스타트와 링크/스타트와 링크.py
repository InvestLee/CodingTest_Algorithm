import sys

N = int(sys.stdin.readline().rstrip())
S = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [False] * N #방문처리된 팀 : 스타트팀, 안된 팀: 링크팀으로 분류
min_result = int(1e9)

def backtracking(num, idx):
    global min_result
    if num == N//2: #절반으로 나누어 지면 인원 배정이 끝났으므로 능력치를 구함.
        start_ability, link_ability = 0, 0
        for i in range(N):
            for j in range(i,N):
                if visited[i] and visited[j]:
                    start_ability += (S[i][j]+S[j][i])
                elif not visited[i] and not visited[j]:
                    link_ability += (S[i][j]+S[j][i])
        min_result = min(min_result,abs(start_ability-link_ability))
        return
    for i in range(idx, N): #모든 경우의 수를 위한 백트래킹(N과 M 문제 참고)
        if not visited[i]:
            visited[i] = True
            backtracking(num+1,i+1)
            visited[i] = False

backtracking(0,0)
print(min_result)
