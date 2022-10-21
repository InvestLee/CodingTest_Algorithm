def solution(order):
    #스택 자료구조
    main_belt = [len(order)-i for i in range(len(order))]
    sub_belt = []
    
    result = 0
    for o in order:
        while True:
            #메인에 있는 경우
            if len(main_belt) > 0 and main_belt[-1] == o:
                main_belt.pop()
                result += 1
                break
            #서브에 있는 경우
            elif len(sub_belt) > 0 and sub_belt[-1] == o:
                sub_belt.pop()
                result += 1
                break
            #메인과 보조 둘다 순서가 아닌 경우
            elif len(main_belt) > 0: 
                sub_belt.append(main_belt.pop())
            #더이상 진행 불가능
            else: 
                return result
                
    return result

#5 4 3 2 1