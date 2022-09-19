#누적 합으로 효율성 해결(미리 모든 스킬 효과 계산)

def solution(board, skill):
    #누적 합 그래프
    graph = [[0] * (len(board[0])+1) for _ in range(len(board)+1)]
    
    #누적 합 기준 상신(4개의 좌표 지그재그로 설계)
    for c, x1, y1, x2, y2, power in skill:
        graph[x1][y1] -= power if c == 1 else -power #올바른 스킬 효과
        graph[x1][y2+1] -= -power if c == 1 else power #누적합 상쇄
        graph[x2+1][y1] -= -power if c == 1 else power #누적합 상쇄
        graph[x2+1][y2+1] -= power if c == 1 else -power #올바른 스킬 효과
    
    #누적 합 행
    for i in range(len(board)):
        for j in range(len(board[0])):
            graph[i][j+1] += graph[i][j]
    
    #누적 합 열
    for i in range(len(board)):
        for j in range(len(board[0])):
            graph[i+1][j] += graph[i][j]
    
    #결과 도출
    result = 0
    for i in range(len(board)):
        for j in range(len(board[0])):
            board[i][j] += graph[i][j]
            if board[i][j] > 0: result += 1
            
    return result