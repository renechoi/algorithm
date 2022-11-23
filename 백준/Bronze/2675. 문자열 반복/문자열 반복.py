for _ in range(int(input())):
    case, words = input().split()
    
    for word in words :
        print(word * int(case), end='')

    print()