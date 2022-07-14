import sys

A, B, C = map(int, sys.stdin.readline().split())

#지수 법칙(a^(b+c)=a^b+a^c)과 나머지 분배 법칙((a*b)%c=(a%c*b%c)%c)을 활용
def multiplex(a,b,c):
    if b == 1:
        return a%c
    else:
        multi = multiplex(a,b//2,c)
        if b%2==0:
            return multi*multi%c
        else:
            return multi*multi*a%c

print(multiplex(A,B,C))