import sys
import math

T = int(sys.stdin.readline().rstrip())

for i in range(T):
    H, W, N = map(int, sys.stdin.readline().split())
    A = math.ceil(N/H) #호수의 열 선언
    print((N-H*(A-1))*100+A) #계산