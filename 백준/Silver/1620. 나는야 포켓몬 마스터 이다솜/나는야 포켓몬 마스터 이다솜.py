import sys

N, M = map(int, sys.stdin.readline().split())
dict = {}
for i in range(N):
    temp = str(sys.stdin.readline().rstrip())
    dict[i+1] = temp
    dict[temp] = i+1
M_list = [str(sys.stdin.readline().rstrip()) for _ in range(M)]

for i in M_list:
    if i.isnumeric():
        print(dict[int(i)])
    else:
        print(dict[i])