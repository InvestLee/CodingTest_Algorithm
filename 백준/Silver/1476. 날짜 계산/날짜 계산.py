import sys

e, s, m = map(int, sys.stdin.readline().split())
earth, sun, moon = 0, 0, 0
result = 0
while True:
    result += 1
    earth += 1
    if earth > 15: earth = 1
    sun += 1
    if sun > 28: sun = 1
    moon += 1
    if moon > 19: moon = 1
    if earth == e and sun == s and moon == m:
        print(result)
        break