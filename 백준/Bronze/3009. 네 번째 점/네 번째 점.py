import sys

A=[0,0,0]
B=[0,0,0]
result=[0,0]
for i in range(3):
    A[i], B[i] = map(int, sys.stdin.readline().split())

for i in range(3): #네 번째 점은 각 축의 홀수 개의 점이다.
    if A.count(A[i]) == 1:
        result[0] = A[i]
    if B.count(B[i]) == 1:
        result[1] = B[i]

print("%d %d"%(result[0],result[1]))