import sys

n = int(sys.stdin.readline().rstrip())
liquid = list(map(int, sys.stdin.readline().split()))

#투 포인터 사용(이미 입력자체가 오름차순)
left = 0
right = n-1
min_result = 2*int(1e9)+1
result_left = 0 #알카리에 가까운 결과값
result_right = 0 #산성에 가까운 결과값
while left < right:
    mix = liquid[left] + liquid[right]
    #0에 가까운 값 산출
    if min_result >= abs(mix):
        min_result = abs(mix)
        result_left = liquid[left]
        result_right = liquid[right]
    if mix < 0:
        left += 1
    else:
        right -= 1

print(result_left, result_right)