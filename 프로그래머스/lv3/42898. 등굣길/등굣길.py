def solution(m, n, puddles):
    #아직 계산안한 곳 = -1, 웅덩이 = 0
    graph = [[-1] * m for _ in range(n)]
    for x, y in puddles:
        graph[y-1][x-1] = 0
    
    #왼쪽 테두리 및 상 테두리 경우의 수 1 대입
    for i in range(m):
        if graph[0][i] == 0:
            break
        graph[0][i] = 1
    for i in range(n):
        if graph[i][0] == 0:
            break
        graph[i][0] = 1
    
    #최단 경로 개수 구하기
    for i in range(1,n):
        for j in range(1,m):
            if graph[i][j] == 0 : continue
            if graph[i-1][j] >= 0 and graph[i][j-1] >= 0:
                graph[i][j] = (graph[i-1][j] + graph[i][j-1]) % 1000000007
            elif graph[i-1][j] >= 0:
                graph[i][j] = graph[i-1][j] % 1000000007
            elif graph[i][j-1] >= 0:
                graph[i][j] = graph[i][j-1] % 1000000007
        
    return graph[n-1][m-1] % 1000000007