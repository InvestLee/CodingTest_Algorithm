def solution(s):
    answer = True
    count = [0,0]
    for i in s:
        if i == "(":
            count[0] += 1
        else:
            count[1] += 1
        if count[1] > count[0]:
            answer = False
            break
    if count[1] != count[0]:
        answer = False
    return answer