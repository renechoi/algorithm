for _ in range(int(input())):
    test_case = list(input())
    
    answer = 0
    score = 0
    
    for character in test_case:
        if character == 'O':
            score += 1
            answer += score
        elif character == "X":
            score = 0
            
    print(answer)