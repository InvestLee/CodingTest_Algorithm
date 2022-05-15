import sys

N = int(sys.stdin.readline().rstrip())
N_list = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline().rstrip())
M_list = list(map(int, sys.stdin.readline().split()))
N_list.sort()

def bin_search(arr,target,start,end): #in은 시간 복잡도 O(N), 이진탐색은 O(logN)
    while start <= end:
        mid = (start+end)//2
        if arr[mid] == target:
            return True
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return False

for i in M_list:
    if bin_search(N_list,i,0,N-1):
        print(1, end=" ")
    else:
        print(0, end=" ")
