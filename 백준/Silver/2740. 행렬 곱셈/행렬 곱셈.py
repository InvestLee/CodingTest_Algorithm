import sys

N, M = map(int,sys.stdin.readline().split())
arr1 = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
M, K = map(int,sys.stdin.readline().split())
arr2 = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]
result = [[0]*K for _ in range(N)]

for i in range(N):
    for j in range(K):
        for k in range(M):
            result[i][j] += arr1[i][k]*arr2[k][j]

for i in range(N):
    for j in range(K):
        print(result[i][j], end=" ")
    print()