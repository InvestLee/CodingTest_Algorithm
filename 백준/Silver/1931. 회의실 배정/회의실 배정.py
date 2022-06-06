import sys

n = int(sys.stdin.readline().rstrip())
T = []
for _ in range(n):
    start, end = map(int, sys.stdin.readline().split())
    T.append([start, end])

#회의가 끝나는 시간 순, 회의 시작 시간이 빠른 순으로 정렬한다.
#회의시간이 일찍 끝날 수 록 더 많은 회의를 넣을 수 있고
#그 후 회의 시작 시간이 빠른 순으로 해야 다 검토 할 수 있기 때문
T.sort(key= lambda x:(x[1],x[0]))

#가장 빨리 끝나는 회의시간부터 스타트를 하며 
#끝나는 시간이 남은 수열 중 가장 빠르며 회의가 안 겹치는 경우를 탐색
count = 1
end_time = T[0][1]
for i in range(1, n):
    if T[i][0] >= end_time:
        count += 1
        end_time = T[i][1]
print(count)