import sys

#문제가 잘못된 게 마을에만 우체국을 설치해야한다는 전제가 없음
#마을에만 우체국을 설치해야한다는 전제가 있으면 마을 위치로 정렬한 후
#마을 하나하나 방문하여 사람수를 적산하면서 과반수를 넘는 마을의 위치가 정답

N = int(sys.stdin.readline().rstrip())
location_peaple = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
location_peaple.sort(key= lambda x:x[0])

total_people = 0
for l, p  in location_peaple:
    total_people += p
total_people = round(total_people/2, 0) #과반수 지점

sum_people = 0
for l, p in location_peaple:
    sum_people += p
    if sum_people >= total_people:
        print(l)
        break