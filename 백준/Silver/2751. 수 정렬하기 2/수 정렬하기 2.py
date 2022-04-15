import sys

def merge_sort(array):
    if len(array)<=1: #배열이 아닌 경우
        return array
    mid = len(array) // 2 #반 자르고
    left = merge_sort(array[:mid]) #왼쪽 배열
    right = merge_sort(array[mid:]) #오른쪽 배열

    i,j,k = 0,0,0

    while i < len(left) and j <len(right): #작은거를 넣는다.
        if left[i] < right[j]:
            array[k] = left[i]
            i += 1
        else:
            array[k] = right[j]
            j += 1
        k+=1 #다음 데이터
    
    if i==len(left): #오른쪽 배열 갯수가 부족할떄 균형 맞추고 마무리
        while j < len(right):
            array[k] = right[j]
            j += 1
            k += 1
    elif j==len(right): #왼쪽 배열 갯수가 부족할떄 균형 맞추고 마무리
        while i < len(left):
            array[k] = left[i]
            i += 1
            k += 1
    return array


n=int(sys.stdin.readline().rstrip())
num = []

for _ in range(n):
    num.append(int(sys.stdin.readline().rstrip()))

num = merge_sort(num)

for i in num:
    print(i)