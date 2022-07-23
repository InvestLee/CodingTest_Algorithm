import sys

N = int(sys.stdin.readline().rstrip())
result = 0
row = [0] * N

def check_possible(x):
    for i in range(x):
        #만약 같은 열이거나 대각선에 다른 퀸이 위치하면
        if row[x] == row[i] or abs(row[x]-row[i]) == abs(x - i):
            return False
    return True

def N_queen(x):
    global result
    if x == N:    
        result += 1 #가능한 케이스 증가
        return
    for i in range(N):
        row[x] = i #퀸 배치
        if check_possible(x):
            N_queen(x+1) #다음 행으로 
                
N_queen(0)
print(result)