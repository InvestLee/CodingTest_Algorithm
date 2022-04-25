import sys
N = int(sys.stdin.readline().rstrip())
count = 0
sixsixsix = 666 #첫번째 값으로 666 지정, 계속 1씩 상승시키면서 비교 예정
while True:
    if '666' in str(sixsixsix): #문자열에 666이 포함되면
        count += 1 #카운트 상승(카운트 = 몇번째숫자인지 판별) 
    if N == count: #지정한 수와 카운트가 일치하면
        print(sixsixsix) #그것을 출력하라
        break
    sixsixsix += 1 #다음 수