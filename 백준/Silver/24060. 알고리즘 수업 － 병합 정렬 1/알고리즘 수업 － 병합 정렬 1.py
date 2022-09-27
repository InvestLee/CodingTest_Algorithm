import sys

result = []

def merge_sort(A, p, r): # A[p..r]을 오름차순 정렬한다.
    if p < r:
        q = (p + r) // 2       # q는 p, r의 중간 지점
        merge_sort(A, p, q);      # 전반부 정렬
        merge_sort(A, q + 1, r);  # 후반부 정렬
        merge(A, p, q, r);        # 병합
    
# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
def merge(A, p, q, r):
    i, j = p, q + 1
    tmp = []
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp.append(A[i]) # tmp[t] <- A[i]; t++; i++;
            i += 1
        else: 
            tmp.append(A[j]) # tmp[t] <- A[j]; t++; j++;
            j += 1
    while i <= q:  # 왼쪽 배열 부분이 남은 경우
        tmp.append(A[i])
        i += 1
    while j <= r:  # 오른쪽 배열 부분이 남은 경우
        tmp.append(A[j])
        j += 1
    i, t =  p, 0
    while i <= r:  # 결과를 A[p..r]에 저장
        A[i] = tmp[t]
        result.append(A[i])
        t += 1
        i += 1


N, K = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))
merge_sort(A,0,len(A)-1)
if len(result) < K:
    print(-1)
else:
    print(result[K-1])