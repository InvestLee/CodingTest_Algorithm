import sys

#좌표압축 = 중복제거 후 오름차순으로 정렬한 숫자들의 순서과 같음

N = int(sys.stdin.readline().rstrip()) #숫자 갯수 입력
num = list(map(int, sys.stdin.readline().split())) #숫자 입력
order = sorted(list(set(num))) #중복제거 후 오름차순 정렬

#for i in range(N):
#    print(order.index(num[i]),end=" ") #index의 시간복잡도는 O(N)이므로 시간 초과가능성있음

#시간복잡도 O(1)인 딕셔너리 사용
dic = {order[i]:i for i in range(len(order))} #key값 : 입력한 숫자, value값 : i(순서)
for i in num:
    print(dic[i],end=' ')