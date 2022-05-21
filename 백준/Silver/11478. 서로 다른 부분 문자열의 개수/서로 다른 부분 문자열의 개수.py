import sys

A = str(sys.stdin.readline().rstrip())
arr = set()

for i in range(len(A)):
    for j in range(i, len(A)):
        arr.add(A[i:j+1])
print(len(arr))