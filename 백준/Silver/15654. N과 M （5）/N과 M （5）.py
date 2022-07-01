import sys

N, M = map(int, sys.stdin.readline().split())
num_arr = list(map(int, sys.stdin.readline().split()))
#수열을 사전 순으로 출력하기 위한 정렬
num_arr.sort()
#한 줄에 출력하는 노드의 중복여부 체크
visited = [False] * N
#리스트의 길이가 M가 같아지면 출력
print_target = []

#백트래킹
def backtracking(M,num_arr,depth):
    if M == depth: #depth가 원하는 출력길이와 같으면 출력
        print(" ".join(map(str,print_target)))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            print_target.append(num_arr[i])
            backtracking(M,num_arr,depth+1) #원소가 추가될 때 마다 depth를 상승
            visited[i] = False #원상복구
            print_target.pop()

backtracking(M,num_arr,0)