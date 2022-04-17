import sys

N = int(sys.stdin.readline().rstrip())
i = 2 #소인수분해는 2부터 시작

while N > 1:
    if N%i ==0: #나머지가 없으면 나눠진다는 뜻
        N //= i #나누기 후
        print(i) #나눈 인자 출력
    else:
        i += 1 #나눈 인자로 더 이상 분해못하면 다음 인자로 넘어가기