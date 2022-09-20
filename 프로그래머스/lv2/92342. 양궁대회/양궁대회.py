from copy import deepcopy

#남는 화살을 고려하여 어피치보다 1발 더 맞히거나 아무것도 안맞히거나 2가지 경우를 고려
#dfs를 이용한 완전탐색으로 해결

max_result, result = 0, []
def solution(n, info):
    def dfs(start,cnt,lion_shoot):
        global max_result, result
        #남는 화살이 없거나 0점에 모조리 쏴야하는 경우 return
        if start == 10 or cnt == 0:
            #사격 종료 후 점수 계산
            lion_result, apeach_result = 0, 0
            for i in range(11):
                #해당 과녁 라이언의 갯수가 더 많고 1발이상 맞췄을 경우
                if info[i] < lion_shoot[i] and lion_shoot[i] != 0:
                    lion_result += 10-i
                #해당 과녁 어피치의 갯수가 같거나 더 많고 1발이상 맞췄을 경우
                elif info[i] != 0:
                    apeach_result += 10-i
            #0점에 모조리 쏘기
            if cnt > 0:
                lion_shoot[start] += cnt
            #점수 차이 최댓값 갱신
            if lion_result-apeach_result > max_result:
                max_result = lion_result-apeach_result
                result = deepcopy(lion_shoot)
            #최댓값이 같은 경우 가장 낮은 점수를 더 많이 맞힌 경우를 return
            elif lion_result-apeach_result == max_result and len(result) == 11:
                for i in range(11):
                    if result[10-i] < lion_shoot[10-i]:
                        result = deepcopy(lion_shoot)
                        break
                    elif result[10-i] > lion_shoot[10-i]:
                        break
            return
        #dfs간 리스트 shallow copy 방지
        temp = deepcopy(lion_shoot)
        #해당 과녁에 아무것도 맞히지 않는 경우
        dfs(start+1,cnt,temp)
        #dfs간 리스트 shallow copy 방지
        temp = deepcopy(lion_shoot)
        #어피치보다 1발 더 맞히는 경우
        if info[start]+1 < cnt:
            temp[start] = info[start]+1
            dfs(start+1,cnt-(info[start]+1),temp)
        #남은 화살 다 쏘는 경우
        else:
            temp[start] = cnt
            dfs(start+1,0,temp)
    dfs(0,n,[0]*11)
    
    #라이언이 한번도 못이기는 경우
    if len(result) == 0: return [-1]
    return result