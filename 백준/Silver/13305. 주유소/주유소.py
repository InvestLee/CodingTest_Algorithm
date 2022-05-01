import sys

N = int(sys.stdin.readline().rstrip())
route = list(map(int, sys.stdin.readline().split()))
city = list(map(int, sys.stdin.readline().split()))
city.pop() #마지막 값은 쓸모없으므로 제거
cost = 0 #비용 계산
count = 0 #for문으로 구현하기에 건너 뛰는 구간이 존재해서 카운트 지정
while True:
    if count >= len(city): #도시방문 종료 시 루프문 종료
        break
    else:
        start = count #현재 주유소의 가격
        for i in range(start+1, len(city)): #차례대로 확인하므로 for문 사용
            if city[i] >= city[start]:
                count += 1 #현재주유소보다 이후 주유소의 가격이 더 저렴하기 직전까지의 루트를 더하기 위함
            else:
                break
        cost += city[start]*sum(route[start:count+1]) #현재주유소 가격에서 다음 더 저렴한 주유소까지의 거리만 비용으로 정산
        count += 1 #다음 더 저렴한 주유소로의 이동
print(cost)