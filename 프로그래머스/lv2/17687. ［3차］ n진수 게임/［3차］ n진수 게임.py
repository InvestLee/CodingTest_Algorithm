def solution(n, t, m, p):
    #11진수~16진수 변환을 위한 리스트
    num_list = [str(i) for i in range(10)] + ['A','B','C','D','E','F']
    #게임 진행 순서
    game_order = []
    #출력하는 예제는 사람수*미리 구할 숫자의 갯수를 넘지 않음
    for i in range(t*m):
        #n진법 계산
        cal_num = []
        while i >= n:
            cal_num.append(num_list[i % n])
            i = i // n
        cal_num.append(num_list[i])
        #게임 진행 순서에 변환한 n진법 추가
        cal_num = cal_num[::-1]
        for c in cal_num:
            game_order.append(c)
    #튜브가 말해야 하는 답안 추출
    answer = ''
    for i in range(t):
        answer += game_order[i*m+p-1]
    return answer