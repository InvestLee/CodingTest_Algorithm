import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    p = list(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline().rstrip())
    #덱으로 설정하여 R 명령 시 cnt를 1씩 상승시켜 2로 나눈 나머지에 따라 D를 처리할 방향을 결정할 수 있음
    #시간복잡도를 위해 마지막에 역전여부를 파악하여 정렬
    arr = deque(sys.stdin.readline().rstrip()[1:-1].split(','))
    if n==0:
        arr = deque() #아무것도 없을 때 입력처리를 하지 않기 위함

    #cnt가 짝수일 때 정방향, cnt가 홀수일 때 역방향
    cnt = 0
    for s in p :
        if s == 'R':
            cnt += 1
        else:
            if len(arr) == 0: #원소가 없을 경우 지우는 게 불가능하므로 에러
                print('error')
                break
            elif cnt % 2 == 0: #정방향(앞부분 원소 삭제)
                arr.popleft()
            else: #역방향(뒷부분 원소 삭제)
                arr.pop()
    else: #break가 난 경우
        if cnt % 2 == 0:
            print("["+",".join(arr)+"]")
        else:
            arr.reverse()
            print("["+",".join(arr)+"]")