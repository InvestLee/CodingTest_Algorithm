import sys

N, M = map(int, sys.stdin.readline().split())
dic = {}
for _ in range(N): #사이트 주소와 비밀번호 입력
    address_site, password = map(str, sys.stdin.readline().split())
    dic[address_site] = password

for _ in range(M): #원하는 사이트 비밀번호 도출
    find_site = sys.stdin.readline().rstrip()
    print(dic[find_site])