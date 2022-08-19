from collections import deque

def solution(queue1, queue2):
    q1 = deque(queue1)
    q2 = deque(queue2)
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    answer = 0
    while True:
        if sum1 == sum2 or answer > 4*len(queue1):
            break
        elif sum1 > sum2:
            sum2 += q1[0]
            sum1 -= q1[0]
            q2.append(q1.popleft())
        else:
            sum1 += q2[0]
            sum2 -= q2[0]
            q1.append(q2.popleft())
        answer += 1
    if answer > 4*len(queue1):
        return -1
    return answer