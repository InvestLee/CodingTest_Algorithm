from collections import defaultdict

def solution(n, results):
    win_dict = defaultdict(set) #key한테 이긴 사람 딕셔너리
    lose_dict = defaultdict(set) #key한테 진 사람 딕셔너리
    for win, lose in results:
        win_dict[lose].add(win) 
        lose_dict[win].add(lose)
    
    #선수 별로 랭킹매기기
    for i in range(1,n+1):
        #i번 선수한테 진 사람
        for w in win_dict[i]:
            lose_dict[w].update(lose_dict[i])
        #i번 선수한테 이긴 사람
        for l in lose_dict[i]:
            win_dict[l].update(win_dict[i])
    
    result = 0
    for i in range(1,n+1):
        if n-1 == len(lose_dict[i])+len(win_dict[i]): result += 1
    
    return result