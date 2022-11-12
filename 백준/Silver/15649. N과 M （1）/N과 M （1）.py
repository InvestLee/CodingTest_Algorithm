import sys

N, M = map(int, sys.stdin.readline().split())
Num = []

def dfs():
    if len(Num)== M:
        print(' '.join(map(str, Num)))
        return
    for i in range(1, N+1):
        if i not in Num:
            Num.append(i)
            dfs()
            Num.pop() #return 후 입력한 수만큼 삭제해준다.
dfs()