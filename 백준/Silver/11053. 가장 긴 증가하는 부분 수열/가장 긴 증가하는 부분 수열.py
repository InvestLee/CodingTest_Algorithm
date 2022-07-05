#증가하는 수열의 형태가 아닌 수열의 길이를 출력하므로 이분탐색 사용

import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))
result_arr = [0]

for a in arr:
    if result_arr[-1] < a: #다음 수열이 증가하는 부분이 맞다면 추가
        result_arr.append(a)
    #이분 탐색을 통해 각 원소의 최적 위치를 찾는다
    #이 과정 중에서 원소의 순서가 바뀔 수 있지만 바뀐 부분말고 다른 부분은 변동없고
    #배열의 크기도 변함이 없기 때문에 사용할 수 있다.
    else: 
        left, right = 0, len(result_arr)
        while left < right:
            mid = (left+right)//2
            if result_arr[mid] < a:
                left = mid + 1
            else:
                right = mid
        result_arr[right] = a

print(len(result_arr)-1)