import sys

N = int(sys.stdin.readline().rstrip())
num = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

num.sort(key=lambda x:x[0]) #2차원 배열 방법
num.sort(key=lambda x:x[1]) #X좌표 먼저 정렬 후 Y좌표로 정렬(뒤로 갈 수 록 우선순위 높아짐)

for i in range(len(num)):
    print('%d %d'%(num[i][0], num[i][1]))