import sys

#이전보다 큰 수로 출력하기 위해 시작점을 설정
#반복문의 시작을 start로 설정하고 다음 재귀를 스타트보다 1 크게 한다.

n, m = map(int, sys.stdin.readline().split())
arr = []
def f(start):
    if len(arr) == m:
        print(' '.join(map(str,arr)))
    for i in range(start,n+1):
        if i in arr:
            continue
        arr.append(i)
        f(i+1)
        arr.pop()
f(1)