import sys
import math
input = sys.stdin.readline

Sosu = [True for i in range(10001)]
Sosu[0], Sosu[1] = False, False

for i in range(2, int(math.sqrt(10000)+1)): #에라토스테네스의 채
    if Sosu[i] == True: #소수불합격 안된것만 동작
        j = 2 #곱하는 기능
        while i*j <= 10000: #범위 안넘게
            Sosu[i*j]=False #얘들 불합격
            j += 1 #다음

M = int(input().rstrip())
N = int(input().rstrip())
L = []

for i in range(M,N+1):
    if Sosu[i] == True:
        L.append(i)
if len(L) == 0:
    print(-1)
else:
    print(sum(L))
    print(L[0])
