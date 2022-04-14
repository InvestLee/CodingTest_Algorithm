import sys

M, N = map(int, sys.stdin.readline().split()) 
C = list(map(int, sys.stdin.readline().split()))
result = 0

#무식하게 다 뒤져 본다

for i in range(M):
    for j in range(i+1, M):
        for k in range(j+1, M):
            if C[i]+C[j]+C[k] > N :
                continue
            else:
                result = max(result, C[i]+C[j]+C[k]) #둘중 큰값
print(result)