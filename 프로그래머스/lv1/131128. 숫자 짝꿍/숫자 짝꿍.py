def solution(X, Y):
    #투포인터 사용
    result = []
    X = list(X)
    Y = list(Y)
    X.sort()
    Y.sort()
    X_idx = 0
    Y_idx = 0
    #크기 비교하며 동일할 시 결과에 추가
    while X_idx < len(X) and Y_idx < len(Y):
        if X[X_idx] == Y[Y_idx]:
            result.append(X[X_idx])
            X_idx += 1
            Y_idx += 1
        elif X[X_idx] < Y[Y_idx]:
            X_idx += 1
        else:
            Y_idx += 1
    result.sort(reverse=True)
    if len(result) == 0: return "-1"
    if len(set(result)) == 1 and list(set(result))[0] == "0": return "0"
    return ''.join(result)