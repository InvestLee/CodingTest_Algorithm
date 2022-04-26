import sys

def facto(A): #팩토리얼 재귀함수는 재귀에러가 걸려서 반복문으로 함
    if A == 1 or A == 0:
        return 1
    result = A
    while(A>1):
        result *= (A-1)
        A -= 1
    return result

N = int(sys.stdin.readline().rstrip())
result = list(str(facto(N))) #각 숫자를 한자리씩 리스트로 분할
result.reverse() #뒤집어서 0이 아닌 수가 나올떄까지 찾는다.
count = 0 #0의 갯수 카운트
for i in result:
    if i == '0': #문자형으로 바꿨기때문에 이렇게 표시했다.
        count += 1
    else:
        print(count)
        break