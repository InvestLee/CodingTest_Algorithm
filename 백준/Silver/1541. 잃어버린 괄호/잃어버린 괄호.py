import sys

# -로 문자열을 나눠준 뒤 리스트의 0번째 위치를 더하고 나머지 위치를 빼주면 된다.

S = sys.stdin.readline().rstrip().split('-')

result = 0
for i in range(len(S)):
    #리스트의 처음 부분은 더한다.
    if i == 0:
        #'+'단위로 분리하여 숫자만 남긴다.
        S[i] = S[i].split('+')
        if len(S[i]) == 1:
            result += int(S[i][0])
        else:
            S[i] = list(map(int, S[i]))
            result += sum(S[i])
    #리스트의 나머지 부분을 뺸다
    else:
        #'+'단위로 분리하여 숫자만 남긴다.
        S[i] = S[i].split('+')
        if len(S[i]) == 1:
            result -= int(S[i][0])
        else:
            S[i] = list(map(int, S[i]))
            result -= sum(S[i])
print(result)