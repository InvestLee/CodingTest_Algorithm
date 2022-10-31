#b^(-1) % 1000000007 = b^(1000000007-2) % 1000000007
#수많은 제곱을 수행하기 위한 분할정복 수행
import sys
sys.setrecursionlimit(int(1e9))
x = 1000000007

def mul(b,times):
    global x
    if times == 1:
        return b % x
    if times % 2 == 0:
        half_mul = mul(b,times//2)
        return half_mul * half_mul % x
    else:
        return b * mul(b,times-1) % x

M = int(sys.stdin.readline().rstrip())
result = 0
for _ in range(M):
    N, S = map(int, sys.stdin.readline().split())
    result += S*mul(N,x-2)%x
    result %= x

print(result)