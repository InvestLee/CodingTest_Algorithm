#늑대의 수가 양의 수보다 더 많아질 때 되돌아가서 다른 노드로 가기 위해 백트래킹 사용
#백트래킹은 재귀할떄마다 반복문을 처음부터 다시 하므로 edges의 정렬여부 상관이 없음
#그러므로 조건 상 불가능할때까지 완전탐색 가능

def solution(info, edges):
    result = [1] #양이 늑대보다 많을 떄의 양의 수 기록
    visited = [0] * len(info) #백트래킹을 위한 방문 처리
    visited[0] = 1 #Root node
    
    def backtracking(sheep, wolf):
        if sheep <= wolf:
            return
        result.append(sheep)
        #부모노드를 방문한 상태에서 자식노드를 방문하지 않았을 경우
        for parent, child in edges:
            if visited[parent] and not visited[child]:
                #자식도 방문
                visited[child] = 1 
                #자식의 유형을 dfs에 기록
                backtracking(sheep+(info[child]^1),wolf+info[child]) 
                #양이 다 잡아먹히기 전에 되돌아가기 
                visited[child] = 0
    #root node가 양
    backtracking(1,0)
    return max(result)