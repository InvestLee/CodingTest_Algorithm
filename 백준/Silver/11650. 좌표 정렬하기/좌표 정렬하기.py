import sys

N = int(sys.stdin.readline().rstrip())
num = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

num.sort(key=lambda x:x[1]) #2차원 배열 방법
num.sort(key=lambda x:x[0])

for i in range(len(num)):
    print('%d %d'%(num[i][0], num[i][1]))