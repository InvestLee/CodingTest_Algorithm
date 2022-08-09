def solution(board):
    #주워진 행렬이 1xn이거나 nx1인 경우
    answer = 0
    for board_row in board:
        for b in board_row:
            if b > answer:
                answer = b
    #사각형 4개의 영역이 모두 1이면 오른쪽 끝 부분에 최솟값을 더해준다.
    for i in range(1,len(board)):
        for j in range(1,len(board[0])):
            if board[i][j] == 1:
                board[i][j] += min(board[i-1][j],board[i][j-1],board[i-1][j-1])
            if answer < board[i][j]:
                answer = board[i][j]
    #가장 큰 정사각형 변의 길이
    return answer**2