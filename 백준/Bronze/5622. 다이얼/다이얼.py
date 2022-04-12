import sys

D = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
S = str(sys.stdin.readline().rstrip())
C = 0
for i in range(len(S)):
    for j in D:
        if S[i] in j:
            C += D.index(j) + 3
print(C)