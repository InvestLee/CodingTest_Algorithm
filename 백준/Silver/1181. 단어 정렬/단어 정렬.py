import sys

N = int(sys.stdin.readline().rstrip())
munja = []
for _ in range(N):
    munja.append(str(sys.stdin.readline().rstrip()))

munja = list(set(munja)) #중복값 제거
munja.sort() #아스키코드상 표기된 문자순서로 정렬
munja.sort(key=lambda x:len(x)) #문자길이 기준으로 정렬


for i in munja:
    print(i)