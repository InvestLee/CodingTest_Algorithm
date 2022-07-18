import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
B, C = map(int, sys.stdin.readline().split())
result = N
for i in range(N):
    A[i] -= B #총감독관 할당
    if A[i]>0: #부감독관 필요시
        if A[i] % C: result += A[i]//C+1
        else: result += A[i]//C

print(result)