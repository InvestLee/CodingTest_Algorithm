import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().split()))
op = list(map(int, sys.stdin.readline().split()))
max_result = int(-1e9)
min_result = int(1e9)

def dfs(result, cnt, plus, minus, multi, divi):
    global N, max_result, min_result
    if cnt == N:
        max_result = max(max_result,result)
        min_result = min(min_result,result)
        return
    #연산자 남아있는거 다 대입해서 최댓값 최솟값 구하는 브루스포스
    if plus>0:
        dfs(result+A[cnt], cnt+1, plus-1, minus, multi, divi)
    if minus>0:
        dfs(result-A[cnt], cnt+1, plus, minus-1, multi, divi)
    if multi>0:
        dfs(result*A[cnt], cnt+1, plus, minus, multi-1, divi)
    if divi>0:
        #정수 나눗셈의 몫, 음수를 양수로 나눌 때 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것
        dfs(int(result/A[cnt]), cnt+1, plus, minus, multi, divi-1)

dfs(A[0], 1, op[0], op[1], op[2], op[3])
print(max_result)
print(min_result)