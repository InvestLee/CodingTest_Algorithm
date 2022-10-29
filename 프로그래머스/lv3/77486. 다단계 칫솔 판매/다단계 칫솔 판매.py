def solution(enroll, referral, seller, amount):
    #유니온 파인드 변형, 해당 인덱스의 부모 리스트
    parent = [i for i in range(len(enroll)+1)]
    result = [0] * (len(enroll)+1)
    
    #구성원들의 인덱스 저장
    dict_idx = {}
    for i in range(len(enroll)):
        dict_idx[enroll[i]] = i+1
    
    #구성원들의 부모 지정
    for i in range(len(referral)):
        if referral[i] == "-": parent[i+1] = 0
        else: parent[i+1] = dict_idx[referral[i]]
    
    #유니온 파인드의 파인드 함수처럼 노드의 부모를 root까지 방문하여 칫솔 판매 처리
    def sell_brush(money,idx):
        if parent[idx] == idx or money // 10 == 0:
            result[idx] += money
            return
        result[idx] += (money - (money // 10))
        sell_brush(money // 10,parent[idx])
    
    for i in range(len(seller)):
        sell_brush(amount[i]*100, dict_idx[seller[i]])
        
    return result[1:]