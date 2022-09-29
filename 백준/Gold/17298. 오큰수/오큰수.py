import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
#오큰수가 없는 경우인 -1을 초기화
result = [-1] * N
#A의 인덱스 0부터 시작
stack_NGE = [0]

for i in range(1,N):
    #stack_NGE[-1] 인덱스의 오큰수 구하기
    #스택으로 쌓인 것중 i위치보다 작은 것들에 오큰수로 삽입
    while stack_NGE and A[stack_NGE[-1]] < A[i]:
        result[stack_NGE.pop()] = A[i]
    #다음으로 구해야 할 오큰수 인덱스 추가
    stack_NGE.append(i)

print(*result)