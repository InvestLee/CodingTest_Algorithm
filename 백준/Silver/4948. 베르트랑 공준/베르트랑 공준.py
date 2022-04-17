import sys
import math

N = int(sys.stdin.readline().rstrip())
while N != 0:
    count = 0
    veri = [True] * (2*N+1)
    veri[0], veri[1] = False, False

    for i in range(2, int(math.sqrt(2*N))+1): #에라토스테네스의 채
        if veri[i] == True:
            j = 2
            while i*j <= 2*N:
                veri[i*j] = False
                j += 1
                
    print(veri[N+1:2*N+1].count(True)) #자연수 N보다 크고 2N보다 작거나 같은 소수 출력
    N = int(sys.stdin.readline().rstrip()) #0으로 입력하면 정지