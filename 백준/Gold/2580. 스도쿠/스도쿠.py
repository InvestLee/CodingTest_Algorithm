import sys

sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]

#빈칸인 부분만 고려
blank_list = [] 
for x in range(len(sudoku)):
    for y in range(len(sudoku)):
        if sudoku[x][y] == 0: blank_list.append((x,y))

#세로 체크
def check_column(y,num):
    for i in range(9):
        if num == sudoku[i][y]:
            return False
    return True

#가로 체크
def check_row(x,num):
    for i in range(9):
        if num == sudoku[x][i]:
            return False
    return True

#해당되는 사각형 체크
def check_squere(x,y,num):
    #소속된 사각형 왼쪽 끝부분부터 체크하기 위해 나머지를 버려서 3의 배수로 만든다.
    nx = x // 3 * 3
    ny = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if num == sudoku[nx+i][ny+j]:
                return False
    return True

def backtraking(start):
    if start == len(blank_list):
        for i in range(9):
            print(*sudoku[i])
        exit(0)
    for num in range(1,10):
        x, y = blank_list[start]
        if check_column(y,num) and check_row(x,num) and check_squere(x,y,num):
            sudoku[x][y] = num
            backtraking(start+1)
            #start == len(blank_list)에 도달하지 않으면 역순하여 하나 씩 빼서 진행
            sudoku[x][y] = 0

backtraking(0)
