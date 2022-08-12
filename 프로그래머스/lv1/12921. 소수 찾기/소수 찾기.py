def solution(n):
    visited = [True] * (n+1)
    visited[0], visited[1] = False, False
    for i in range(2,int((n+1)**(1/2))+1):
        j = 2
        while i*j <= n:
            visited[i*j]=False
            j+=1
    
    return visited.count(True)