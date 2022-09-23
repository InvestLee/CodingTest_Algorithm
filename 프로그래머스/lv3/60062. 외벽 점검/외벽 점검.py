from itertools import permutations

def solution(n, weak, dist):
    #친구 수의 최솟값을 return해야 하므로 default값을 친구 수 보다 크게 잡는다.
    result = 9
    #원형 레스토랑의 선형화
    weak_length = len(weak)
    weak = weak + [w+n for w in weak]
    #친구가 투입되는 경우의 수
    dist_length = len(dist)
    dist = list(permutations(dist))
    
    for i in range(weak_length):
        #시작점을 변경하면서 점검
        temp_weak = weak[i:i+weak_length]
        #친구를 투입하여 점검이 되는지 판별
        for d in dist:
            friend_input = 1 #친구 투입 수
            check_wall = temp_weak[0] + d[friend_input-1] #점검한 벽의 범위 0~N
            for i in range(weak_length):
                #점검 안된 벽이 있다면 친구 추가 투입
                if temp_weak[i] > check_wall:
                    friend_input += 1
                    #친구를 다 투입했는데 점검안된 벽이 있는 경우 다음 경우의 수로
                    if friend_input > len(d):
                        break
                    check_wall = temp_weak[i] + d[friend_input-1] #다음 친구를 투입했을 때 점검한 벽의 범위
            #친구 투입한 최솟값 판별
            result = min(result,friend_input)
    
    if result == dist_length+1: return -1
    return result