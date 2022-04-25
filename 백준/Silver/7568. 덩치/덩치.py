import sys
N = int(sys.stdin.readline().rstrip()) #전체 사람 수
A = [0] * N #몸무게
B = [0] * N #키
C = [1] * N #순위(자신보다 덩치가 크거나 같은 사람이 몇명인지 카운트, Default 1)
for i in range(N):
    A[i], B[i] = map(int, sys.stdin.readline().split()) #입력

for i in range(N):
    for j in range(N):
        if A[i] < A[j] and B[i] < B[j]: #순위 = 자신보다 덩치 크거나 같은 사람의 수
            C[i] += 1 #사람의 수 증가

for i in range(N):
    print(C[i],end=' ')