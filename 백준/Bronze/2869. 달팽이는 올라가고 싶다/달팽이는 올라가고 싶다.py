import sys
import math #올림
#(Day-1)*(A-B)+A > V
A, B, V = map(int, sys.stdin.readline().split())
D = math.ceil((V-A)/(A-B)+1) 
print(D)