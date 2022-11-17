for _ in range(int(input())) :
    
    test_case = list(map(int, input().split()))
    
    average = sum(test_case[1:]) / test_case[0]
    students_with_high_score = 0    
    
    for score in range(1, len(test_case)) :
        
        if test_case[score] > average :
            students_with_high_score += 1    
            
    percent = students_with_high_score*100/test_case[0]
    
    print(f"{percent:.3f}%")