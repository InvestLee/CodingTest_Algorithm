import sys

N = int(sys.stdin.readline().rstrip())
a = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline().rstrip())
b = list(map(int, sys.stdin.readline().split()))

#딕셔너리(해쉬맵)을 사용하여 각 인자의 갯수 계산
dict={}
for i in a:
    if i in dict:
        dict[i] +=1
    else:
        dict[i] = 1

#딕셔너리에 없으면 0 있으면 값을 출력
for i in b:
    result = dict.get(i)
    if result == None:
        print(0,end=' ')
    else:
        print(result,end=' ')