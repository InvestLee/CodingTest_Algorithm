import sys

S = sys.stdin.readline().rstrip()
N = int(sys.stdin.readline().rstrip())
#arr[문자열 길이][a-z 알파벳 26개]
arr = [[0]*26 for _ in range(len(S))]
#첫번째 글자 업데이트
arr[0][ord(S[0])-97]=1
#그 이후 글자 적용
for i in range(1,len(S)):
    arr[i][ord(S[i])-97]=1
    #지금까지 글자수 누적
    for j in range(26):
        arr[i][j] += arr[i-1][j]

for _ in range(N):
    a, l, r = map(str, sys.stdin.readline().split())
    if int(l) > 0:
        print(arr[int(r)][ord(a)-97]-arr[int(l)-1][ord(a)-97])
    else:
        print(arr[int(r)][ord(a)-97])