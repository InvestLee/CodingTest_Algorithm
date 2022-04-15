import sys
A, B = map(int, sys.stdin.readline().split())

while A != 0 or B != 0:
    if B%A == 0:
        print('factor')
    elif A%B == 0:
        print('multiple')
    else:
        print('neither')
    A, B = map(int, sys.stdin.readline().split())