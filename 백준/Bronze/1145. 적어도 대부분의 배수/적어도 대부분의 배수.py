numbers = list(map(int,input().split()))

cnt = 0
brute_minimum_multiple = 1

while cnt < 3:
    cnt = 0
    
    for number in numbers:
        if brute_minimum_multiple % number == 0 :
            cnt += 1
        if cnt == 3:
            break
    brute_minimum_multiple += 1

print(brute_minimum_multiple-1)