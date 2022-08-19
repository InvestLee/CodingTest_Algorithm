def solution(survey, choices):
    result = ""
    #성격 유형 딕셔너리 화
    personal = {"RT":0,"CF":0,"JM":0,"AN":0}
    #성격유형점수 산정을 위한 연산
    for i in range(len(choices)):
        choices[i] -= 4
    #성격유형 점수 연산
    for i in range(len(survey)):
        if survey[i] in personal:
            personal[survey[i]] += choices[i]
        else:
            personal[survey[i][::-1]] -= choices[i]
    #성격유형 판별
    for k, v in personal.items():
        if v > 0:
            result += k[1]
        else:
            result += k[0]
    return result