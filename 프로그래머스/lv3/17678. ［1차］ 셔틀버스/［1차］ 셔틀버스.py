def solution(n, t, m, timetable):
    #순차적으로 버스를 탑승시키기 위한 정렬
    timetable.sort(reverse=True)
    
    #초 단위로 환산
    for i in range(len(timetable)):
        temp = list(map(int, timetable[i].split(":")))
        timetable[i] = temp[0]*60+temp[1]
    
    start = 9*60 #첫 셔틀 도착 시간
    last_people = 0 #마지막 셔틀버스에 탑승하는 마지막 사람의 도착 시간
    while n > 0:
        temp_m = m #남는 좌석
        for i in range(len(timetable)-1,-1,-1):
            if timetable[i] <= start:
                last_people = timetable.pop() #순서대로 탑승
                temp_m -= 1
            if temp_m == 0: break #남는 좌석이 없으면 다음 버스
        start += t
        n -= 1
    
    Hour_con = (last_people-1)//60
    minute_con = (last_people-1)%60
    #아무도 탑승하지 못하는 경우이거나 좌석이 남는 경우
    if Hour_con < 0 or temp_m > 0:
        Hour_con = (start-t)//60
        minute_con = (start-t)%60
    
    #정답 형식 맞추기
    answer = "{:02d}:{:02d}".format(Hour_con,minute_con)
    
    return answer