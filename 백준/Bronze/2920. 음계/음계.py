import sys

arr = list(map(int, sys.stdin.readline().split()))
asc = sorted(arr)
desc = sorted(arr,reverse=True)
if arr==asc: print("ascending")
elif arr==desc: print("descending")
else: print("mixed")