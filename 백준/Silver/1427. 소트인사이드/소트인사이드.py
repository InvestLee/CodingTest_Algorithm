import sys

N = list(map(int,sys.stdin.readline().rstrip()))
N = sorted(N, reverse=True)
for i in N:
    print(i,end='')