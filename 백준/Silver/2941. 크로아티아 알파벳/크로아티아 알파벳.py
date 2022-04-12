import sys

C = ['c=','c-','dz=','d-','lj','nj','s=','z=']
S = str(sys.stdin.readline().rstrip())
T = 0
for i in range(len(C)):
    if C[i] in S:
        T += S.count(C[i])
        S = S.replace(C[i]," ")
S=S.replace(" ","")
print(T+len(S))