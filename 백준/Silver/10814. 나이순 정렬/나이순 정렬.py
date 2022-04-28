import sys

N = int(sys.stdin.readline().rstrip())
age_name = [list(map(str, sys.stdin.readline().split())) for _ in range(N)]


age_name.sort(key=lambda x:int(x[0])) #나이를 정수형으로 바꾼 뒤 기준으로 삼고 정렬

for i in age_name:
    print("%d %s"%(int(i[0]),i[1]))