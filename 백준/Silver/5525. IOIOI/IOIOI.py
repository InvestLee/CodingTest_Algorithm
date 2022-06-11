import sys

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
S = sys.stdin.readline().rstrip()

#최종 결과, N과 비교하기 위한 OI반복 카운트, 문자열 지정
result, count, i = 0, 0, 0

while i < (M-1):
    if S[i:i+3] == 'IOI':
        #다음이 O가 올 위치이므로 다음 I 탐색을 위해 +2
        i += 2
        #OI 반복 갯수
        count += 1
        if count == N:
            result += 1
            #다음 i += 2에서 또 조건에 만족하면 동일하게 진행해야 하므로
            count -= 1 
    else:
        i += 1
        #카운트 초기화
        count = 0

print(result)