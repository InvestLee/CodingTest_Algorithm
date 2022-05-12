import sys

n = int(sys.stdin.readline().rstrip())
a = sorted(list(map(int, sys.stdin.readline().split())))
x = int(sys.stdin.readline().rstrip())
count = 0
left, right = 0, n-1
while left<right:
    twosum = a[left]+a[right]
    if twosum < x:
        left += 1
    elif twosum == x:
        count+= 1
        left += 1
    else:
        right -= 1
print(count)