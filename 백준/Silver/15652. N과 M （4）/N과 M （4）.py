import sys

#중복 허용+start점 지정하여 이전값보다 큰 수를 넣을 수 있게 한다.

n, m = map(int, sys.stdin.readline().split())
arr = []
def f(start):
    if len(arr) == m:
        print(' '.join(map(str,arr)))
        return
    for i in range(start,n+1):
        arr.append(i)
        f(i)
        arr.pop()
f(1)