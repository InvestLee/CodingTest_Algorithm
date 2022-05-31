import sys

N, M = map(int, sys.stdin.readline().split())
wood = list(map(int, sys.stdin.readline().split()))

start, end = 0, max(wood) #높이 0부터 존재하는 나무의 최대 높이
while start <= end: #이분 탐색
    wood_length = 0
    mid = (start+end)//2
    for w in wood:
        if w-mid > 0: #목재절단기가 나무보다 낮아야 절단됨
            wood_length += w-mid #획득 나무 길이
    if wood_length >= M: #나무 길이를 너무 많이 얻어서 목재절단기 높이 상승
        start = mid + 1
    else:
        end = mid - 1
print(end)