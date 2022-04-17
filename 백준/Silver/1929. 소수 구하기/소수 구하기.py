import sys
import math

M, N = map(int, sys.stdin.readline().split())

veri = [True] * (N+1) #에라토스테네스의 채에서 소수여부 결정
veri[0], veri[1] = False, False #0하고 1은 제외

for i in range(2, int(math.sqrt(len(veri))+1)): #에라토스테네스의 채
    if veri[i] == True:
        j = 2
        while i*j <= N:
            veri[i*j] = False
            j += 1

for i in range(M,N+1):
    if veri[i] == True:
        print(i)