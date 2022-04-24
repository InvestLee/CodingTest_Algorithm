import sys
import math
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    A = list(map(int, sys.stdin.readline().split()))
    length = math.sqrt(math.pow(abs(A[3]-A[0]),2)+math.pow(abs(A[4]-A[1]),2))
    if length == 0 and A[2] == A[5]:
        print(-1)
    elif length == (A[2]+A[5]) or length == (abs(A[2]-A[5])):
        print(1)
    elif length > (A[2]+A[5]) or length < (abs(A[2]-A[5])):
        print(0)
    else:
        print(2) 