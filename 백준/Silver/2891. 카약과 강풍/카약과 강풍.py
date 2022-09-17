import sys

N, S, R = map(int, sys.stdin.readline().split())
damaged_kayak = set(map(int, sys.stdin.readline().split()))
spare_kayak = set(map(int, sys.stdin.readline().split()))
have_two_kayak = spare_kayak-damaged_kayak #멀쩡한 카약이 2개 있는 팀
have_nothing_kayak = damaged_kayak-spare_kayak #멀쩡한 카약이 없어서 빌려야 되는 팀
result = 0
for i in have_nothing_kayak:
    #이전 팀한테 빌리기
    if i-1 in have_two_kayak:
        have_two_kayak.remove(i-1)
    #다음 팀한테 빌리기
    elif i+1 in have_two_kayak:
        have_two_kayak.remove(i+1)
    #빌릴 팀이 없는 경우 출전 못함
    else:
        result+=1
print(result)