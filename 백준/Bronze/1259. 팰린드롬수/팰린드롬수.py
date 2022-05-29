import sys

while True:
    num = str(sys.stdin.readline().rstrip())
    if num == '0':
        break 
    if num == num[::-1]:
        print("yes")
    else:
        print("no")