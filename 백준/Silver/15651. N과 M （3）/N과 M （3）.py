import sys

#중복 허용

n, m = map(int, sys.stdin.readline().split())
arr = []
def f():
    if len(arr) == m:
        print(' '.join(map(str,arr)))
        return
    for i in range(1,n+1):
        arr.append(i)
        f()
        arr.pop()
f()