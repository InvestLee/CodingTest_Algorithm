import math

def solution(fees, records):
    for i in range(len(records)): #시각 / 차량번호 / 내역
        records[i] = records[i].split(' ')
    for i in range(len(records)): #분단위로 환산
        records[i][0] = int(records[i][0][:2])*60+int(records[i][0][3:])
    records.sort(key= lambda x:x[1]) #차량번호 기준으로 정렬
    result_time = [-records[0][0]]
    temp = 1 #입차된 이후 출차된 내역이 없는 경우를 구분하기 위함
    for i in range(1,len(records)): #주차 시간 계산
        if records[i][1] != records[i-1][1]:
            if temp == 1:
                result_time[-1] += 23*60+59
                temp = 0
            result_time.append(-records[i][0])
            temp = 1
        else:
            if records[i][2] == 'IN':
                result_time[-1] -= records[i][0]
                temp = 1
            else:
                result_time[-1] += records[i][0]
                temp = 0
    if temp == 1: #마지막 내역 점검
        result_time[-1] += 23*60+59
        
    result = []        
    for t in result_time: #요금 계산
        if t > fees[0]:
            result.append(fees[1]+math.ceil((t-fees[0])/fees[2])*fees[3])
        else:
            result.append(fees[1])
    return result