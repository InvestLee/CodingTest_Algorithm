import heapq

def solution(n, paths, gates, summits):
    graph = [[] for _ in range(n+1)]
    for a,b,c in paths:
        graph[a].append((b,c))
        graph[b].append((a,c))
    
    #각 출입구에서 출발하여 i지점까지 올 때 최소 intensity
    Distance = [int(1e9)] * (n+1)
    #출입구 입력
    q=[]
    for g in gates:
        heapq.heappush(q,(0,g))
        Distance[g] = 0
    
    summits = set(summits)
    while q:
        dist, now  = heapq.heappop(q)
        #산봉우리 경유 금지
        if now in summits: continue
        #그 지점까지 가는 intensity보다 큰 경우 무시(그 지점 intensity 최솟값 염두)
        if Distance[now] < dist:
            continue
        #등산로 intensity 갱신
        for i in graph[now]:
            cost = max(dist,i[1])
            if cost < Distance[i[0]]:
                Distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))
    
    #intensity가 최소과 되고 번호가 가장 낮은 등산코스
    summits = sorted(list(summits))
    answer = [0,int(1e9)]
    for s in summits:
        if answer[1] > Distance[s]:
            answer = [s,Distance[s]]
    
    return answer