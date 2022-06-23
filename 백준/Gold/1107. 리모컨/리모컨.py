import sys

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
if M > 0:
    btn_forbid = set(sys.stdin.readline().split())
else:
    btn_forbid = set() #고장난 버튼이 없는 경우(아래 조건문 오류 방지)

#위 아래 버튼만 눌렀을 때를 최솟값의 디폴트로 설정
min_cnt = abs(N - 100)
for num in range(1000001):
    for i in str(num):
        if i in btn_forbid:
            break
    # for else문 : 모든 반복이 수행되어야 한번 수행
    # => break문을 통해 모든 반복이 일어나지 않았으므로 무시
    else: #해당 버튼이 다 멀쩡한 경우 최솟값 계산
        min_cnt = min(min_cnt,len(str(num))+abs(num-N))
print(min_cnt)