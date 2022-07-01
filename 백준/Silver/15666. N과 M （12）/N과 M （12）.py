import sys

N, M = map(int, sys.stdin.readline().split())
#같은 수를 여러번 골라도 된다=>횟수 제한이 없으므로 모든 노드 공평하게 중복사항 제거
num_arr = list(set(map(int, sys.stdin.readline().split())))
#문제 지문 : 고른 수열은 비내림차순이어야 한다.
num_arr.sort()
print_num = []

def backtracking(start):
    if len(print_num) == M:
        print(*print_num)
        return
    #사전순으로 증가하는 수열을 출력하기 위해 start지점 기준으로 재귀
    for i in range(start,len(num_arr)):
        print_num.append(num_arr[i])
        backtracking(i)
        print_num.pop()

backtracking(0)