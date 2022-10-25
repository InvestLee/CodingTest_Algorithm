#유니온 파인드를 통해 각 그룹을 나누기

def solution(cards):
    parent = [i for i in range(len(cards)+1)]
    
    def find_parent(a,parent):
        if parent[a] != a:
            parent[a] = find_parent(parent[a],parent)
        return parent[a]
    
    def union_parent(a,b,parent):
        a = find_parent(a,parent)
        b = find_parent(b,parent)
        if a > b:
            parent[a] = b
        else:
            parent[b] = a
    
    #그룹 설정
    for i in range(len(cards)):
        union_parent(cards[i],i+1,parent)
    
    #루트노드가 같은 요소는 동일 그룹
    for i in range(len(parent)):
        find_parent(i,parent)
    
    #0이라는 카드가 없으므로 제거
    parent.remove(0)
    
    #점수 출력
    result = []
    set_parent = set(parent)
    if len(set_parent) == 1: return 0 #루트 노드가 하나라면 그룹이 한 개 이므로 점수 0점
    for p in set_parent:
        result.append(parent.count(p))
    result.sort(reverse=True)
    return result[0]*result[1]