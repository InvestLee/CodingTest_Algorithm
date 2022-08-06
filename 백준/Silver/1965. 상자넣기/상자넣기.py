import sys

n = int(sys.stdin.readline().rstrip())
box_list = list(map(int, sys.stdin.readline().split()))

#가장 긴 증가하는 수열 문제와 같음
result = [0]
for b in box_list:
    if b > result[-1]:
        result.append(b)
    else:
        left, right = 0, len(result)
        while left < right:
            mid = (left+right)//2
            if result[mid] < b:
                left = mid+1
            else:
                right = mid
        result[right] = b
print(len(result)-1)