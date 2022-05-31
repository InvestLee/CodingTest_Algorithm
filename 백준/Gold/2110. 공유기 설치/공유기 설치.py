import sys

N, M = map(int, sys.stdin.readline().split())
wifi = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
wifi.sort()
#시작점 : 집 사이 거리 최소 1, 끝점 : 끝집과 처음 집까지의 거리
start, end = 1, wifi[-1]-wifi[0] 

while start <= end:
    mid = (start+end)//2 #가장 먼 거리를 위한 이분 탐색
    install_wifi = wifi[0] #가장 먼 거리이므로 시작지점부터 설치
    count = 1 #설치한 횟수
    for w in wifi:
        #현재 지점과 설치 지점거리가 설정 거리보다 클때 공유기 설치
        if w - install_wifi >= mid: 
            count += 1 #공유기 설치 횟수 증가
            install_wifi = w #다음 지점 설정
    if count >= M: #공유기가 더 많이 설치되어 있거나 같으면(최댓값을 위해 =)
        start = mid + 1 #좀 더 먼거리에 설치를 위해 시작점 증가
        result = mid #현재 거리 저장
    else:
        end = mid - 1 
print(result)