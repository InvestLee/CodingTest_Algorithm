import sys

def facto(A): #팩토리얼 재귀함수는 재귀에러가 걸려서 반복문으로 함
    if A == 1 or A == 0:
        return 1
    result = A
    while(A>1):
        result *= (A-1)
        A -= 1
    return result

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    print(facto(K)//facto(N)//facto(K-N)) #이항계수 공식