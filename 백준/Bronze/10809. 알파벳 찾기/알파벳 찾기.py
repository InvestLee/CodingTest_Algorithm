import sys

S = str(sys.stdin.readline().rstrip())
A = "abcdefghijklmnopqrstuvwxyz"

for i in A:
    print(S.find(i), end=" ")