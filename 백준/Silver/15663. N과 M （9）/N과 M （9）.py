import sys

N, M = map(int, sys.stdin.readline().split())
arr = sorted(list(map(int, sys.stdin.readline().split())))
print_node = []
visited = [False] * N #같은 위치의 수 출력 방지

def backtracking():
    global before_arr
    if len(print_node) == M:
        before_arr = ' '.join(map(str, print_node))
        print(' '.join(map(str, print_node)))
        return
    temp = 0 #중복되는 수열을 여러 번 출력하는 것을 방지하기 위함
    for i in range(len(arr)):
        if not visited[i] and temp != arr[i]: #다른 위치의 요소만 출력
            print_node.append(arr[i])
            visited[i] = True
            temp = arr[i]
            backtracking()
            visited[i] = False
            print_node.pop()

#처음에는 수열에 해당이 안되는 수를 입력하여 전부 고려하게 함
backtracking()