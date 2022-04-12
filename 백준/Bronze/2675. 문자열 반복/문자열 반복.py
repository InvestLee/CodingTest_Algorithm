import sys

N = int(sys.stdin.readline().rstrip())
for j in range(N):
    temp, S = map(str, sys.stdin.readline().split())
    R = int(temp)
    for i in S:
        print(i*R, end="")
    print("")