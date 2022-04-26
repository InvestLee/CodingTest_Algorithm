import sys
import math
N = int(sys.stdin.readline().rstrip()) #숫자 갯수 입력
num = [] #숫자 입력
interval = [] #(A1-A2) = (B1-B2)*M + 나머지-나머지
for _ in range(N): #숫자 입력
    num.append(int(sys.stdin.readline().rstrip()))
num = sorted(num) #정렬

def Gcd(a, b): #유클리드 호제법
    r = a % b
    while r != 0:
        a,b = b, r
        r = a % b
    return b

gcd = num[1]-num[0] #(A1-A2) = (B1-B2)*M이므로 각 식의 차의 최대공약수를 구하기 위한 초기값
for i in range(2,N):
    gcd = Gcd(gcd,num[i]-num[i-1]) #모든 항의 최대 공약수 탐색
result = [gcd] #본인을 포함한 약수 목록 출력(물론 1은 제외해야함)

for i in range(2, int(math.sqrt(gcd))+1): #약수 목록에서 본인의 제곱근까지만 구하면 다 구해짐
    if gcd % i == 0: #약수맞으면
        result.append(i) #추가
        if i != gcd//i: #제곱이 아니면
            result.append(gcd//i) #얘도 추가
result = sorted(result) #오름차순 정렬
print(*result) #*표시는 리스트를 일반적으로 출력하라는 표시