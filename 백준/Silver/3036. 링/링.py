import sys

def Gcd(a, b): #유클리드 호제법
    r = a % b
    while r != 0:
        a,b = b, r
        r = a % b
    return b

N = int(sys.stdin.readline().rstrip()) #링 갯수 입력
num = list(map(int, sys.stdin.readline().split())) #링 반지름 입력
gcd = [] #최소공약수 리스트(링 바퀴수는 최소공약수로 나눠준 값이다.)
for i in range(1,N): #첫번쨰 링과 각 링의 최소공약수 계산
    gcd.append(Gcd(num[0],num[i]))

for i in range(N-1): #최소공약수로 나눠줌으로써 몇바퀴인지 계산
    print("%d/%d"%(num[0]//gcd[i],num[i+1]//gcd[i]))