import sys

K, N = map(int, sys.stdin.readline().split())
line = []
for _ in range(K):
    line.append(int(sys.stdin.readline().rstrip()))
start, end = 1, max(line) #길이 1 ~ 랜선 최대 길이

while start <= end: #이분탐색
    number = 0 #mid기준으로 잘려진 랜선 수
    mid = (start+end) // 2
    for l in line:
        number += l//mid #랜선마다 mid로 나눈 몫 = 잘려진 수
    if number >= N: #더 많이 짤리면 mid를 크게 하기 위해 start 조정
        start = mid+1
    else: #더 적게 짤리면 mid를 작게 하기 위해 start 조정
        end = mid-1
print(end) #조건을 만족하는 최대 랜선 길이(최소 랜선 길이~start~end)