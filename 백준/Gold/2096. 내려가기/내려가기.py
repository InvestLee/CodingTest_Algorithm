import sys

#메모리 제한으로 배열 선언을 최소화

N = int(sys.stdin.readline().rstrip())
#가장 크게 더하는 경우
high_graph = [[0 for _ in range(3)] for _ in range(2)]
#가장 작게 더하는 경우
low_graph = [[0 for _ in range(3)] for _ in range(2)]
#초기값 대입
high_graph[0] = list(map(int, sys.stdin.readline().split()))
low_graph[0] =  [h for h in high_graph[0]]

for _ in range(N-1):
    high_graph[1] = list(map(int, sys.stdin.readline().split()))
    low_graph[1] =  [h for h in high_graph[1]]
    for j in range(0,3):
        #젤 처음
        if j == 0:
            high_graph[1][j] += max(high_graph[0][j],high_graph[0][j+1])
            low_graph[1][j] += min(low_graph[0][j],low_graph[0][j+1])
        #끝 부분
        elif j == 2:
            high_graph[1][j] += max(high_graph[0][j],high_graph[0][j-1])
            low_graph[1][j] += min(low_graph[0][j],low_graph[0][j-1])
        else:
            high_graph[1][j] += max(high_graph[0][j],high_graph[0][j-1],high_graph[0][j+1])
            low_graph[1][j] += min(low_graph[0][j],low_graph[0][j-1],low_graph[0][j+1])
    high_graph[0] = [h for h in high_graph[1]]
    low_graph[0] =  [h for h in low_graph[1]]

print(max(high_graph[0]), min(low_graph[0]))