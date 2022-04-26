import sys
T = int(sys.stdin.readline().rstrip())
for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    if B > A: #큰 수로 작은 수를 나누기 위해
        Big_num, Small_num = B, A
    else:
        Big_num, Small_num = A, B
    while(True):
        Big_num, Small_num = Small_num, Big_num % Small_num #유클리드 호제법(나머지가 0이 될때까지 나눈다)
        if Small_num == 0: #나머지가 0, 그 전값 = 최대 공약수
            print(A*B//Big_num) #기존값의 곱/최대공약수 = 최소공배수
            break