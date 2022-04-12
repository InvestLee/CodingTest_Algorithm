import sys

S = list(str(sys.stdin.readline().rstrip().upper()))
N = []
A = []
C = set(S)
for i in C:
    N.append(S.count(i))
    A.append(i)

if N.count(max(N)) > 1 :
    print("?")
else:
    print(A[N.index(max(N))])