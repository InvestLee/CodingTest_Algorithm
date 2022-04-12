import sys

N = int(sys.stdin.readline().rstrip())
A = []
count = 0
NotCount = 0
for i in range(N):
    A.append(str(sys.stdin.readline().rstrip()))
for j in A:
    for k in range(len(j)):
        if k+2 >= len(j):
            break
        elif j[k] != j[k+1]:
            for w in range(k+2, len(j)):
                if j[k] == j[w]:
                    NotCount +=1
                    break
    if NotCount == 0 or len(j) == 1 or len(j) == 2:
        count +=1
    NotCount = 0
print(count)