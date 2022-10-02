#투 포인터

import sys

N = int(sys.stdin.readline().rstrip())
liquid = list(map(int, sys.stdin.readline().split()))
liquid.sort() #투 포인터를 사용하기 위한 정렬

is_this_zero = 2*int(1e9) #초기값은 조건보다 큰 값으로 설정

start = 0 #좌측 탐색
end = N-1 #우측 탐색 
result1, result2 = 0, 0 #결과값
while start < end:
    spec = liquid[start]+liquid[end]
    if is_this_zero > abs(spec): #0에 더 가까우면 결과값 상신
        is_this_zero = abs(spec)
        result1, result2 = liquid[start], liquid[end]
    if spec > 0:
        end -= 1
    else:
        start += 1
        
print(result1, result2)