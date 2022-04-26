import sys

N = int(sys.stdin.readline().rstrip()) #약수의 갯수 입력
A = list(map(int, sys.stdin.readline().split())) #약수 입력
print(max(A)*min(A)) #약수가 모두 있다고 가정하면 최솟값*최댓값 정답이다.