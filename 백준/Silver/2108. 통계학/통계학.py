import sys
from collections import Counter #라이브러리 사용안하면 최빈값에서 시간초과

N = int(sys.stdin.readline().rstrip()) #수의 갯수 입력
num = []
for i in range(N):
    num.append(int(sys.stdin.readline().rstrip())) #수 입력
num = sorted(num) #중앙값을 위한 수 정렬

print(round(sum(num)/len(num))) #산술평균(소수점 반올림)

print(num[len(num)//2]) #중앙값

freq = Counter(num).most_common() #데이터 갯수가 많은 순(이미 num은 작은순으로 정렬)
if len(freq) > 1 and freq[0][1] == freq[1][1]: #최빈 값이 2개이상이면
    max_freq = freq[1][0] #2번째 최빈값 지정
else:
    max_freq = freq[0][0] #최빈값 지정
print(max_freq) #두 번째로 작은 최빈값

#시간초과나는 최빈값
#set_num = sorted(list(set(num))) #두 번째로 작은 최빈 값을 위해 중복제거 및 정렬
#freq = [] #num에서의 같은 숫자 갯수를 알아보기 위한 리스트
#for i in range(len(set_num)):
#    freq.append(num.count(set_num[i])) #각 수마다 갯수 대입
#if freq.count(max(freq)) > 1: #최빈 값이 1개보다 많으면
#    del set_num[freq.index(max(freq))] #첫번쨰로 작은 최빈값 제거
#    del freq[freq.index(max(freq))] #위치로 찾기 위해 빈도수도 제거하여 일치시킴
#print(set_num[freq.index(max(freq))]) #첫번쨰가 삭제되었으니 그 다음 최빈값 출력

print(num[len(num)-1]-num[0]) #범위 출력