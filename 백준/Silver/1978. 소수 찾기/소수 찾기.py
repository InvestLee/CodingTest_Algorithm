import sys
import math

Sosu = [True for i in range(1001)] #소수 여부
Sosu[1] = False
for i in range(2, int(math.sqrt(1000))+1): #2부터 1000의 제곱근까지
    if Sosu[i] == True:
        j = 2 #커지면서 더해지면서 소수 아닌거 걸러내기
        while i*j <= 1000:
            Sosu[i*j]=False #넌 소수가 아니다
            j += 1

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
Count = 0
for i in range(N):
    if Sosu[A[i]] == True:
        Count += 1
print(Count)