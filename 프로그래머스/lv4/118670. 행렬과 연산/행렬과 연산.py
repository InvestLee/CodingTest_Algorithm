from collections import deque

#아래와 같이 첫열과 마지막열 덱 그리고 첫열과 마지막열을 제외한 행별 덱을 구성하여 효율성을 해결
#1 111 1
#2 222 2
#3 333 3
#4 444 4
#5 555 5

def solution(rc, operations):
    #첫열과 마지막열을 제외한 행별 덱
    rc_row = deque(deque(r[1:-1]) for r in rc)
    #첫열과 마지막열 덱
    rc_column = [deque(rc[i][0] for i in range(len(rc))),deque(rc[i][len(rc[0])-1] for i in range(len(rc)))]
    
    for o in operations:
        #각 끝부분 요소를 고려하여 회전
        if o == "Rotate": 
            rc_row[len(rc)-1].append(rc_column[1].pop())
            rc_column[0].append(rc_row[len(rc)-1].popleft())
            rc_row[0].appendleft(rc_column[0].popleft())
            rc_column[1].appendleft(rc_row[0].pop())
        if o == "ShiftRow":
            rc_row.rotate(1)
            rc_column[0].rotate(1)
            rc_column[1].rotate(1)
    
    #분리된 덱을 리스트로 합치기
    result = [[] for _ in range(len(rc))]
    for i in range(len(rc)):
        result[i].append(rc_column[0][i])
        result[i].extend(rc_row[i])
        result[i].append(rc_column[1][i])
    
    return result