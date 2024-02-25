import sys
M=[]
N=int(input())
for _ in range(N):
    M.append(int(sys.stdin.readline()))
for i in sorted(M):
    print(i)