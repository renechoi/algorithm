X = int(input())
diagonal_line=1

while(X > 0):
    X -= diagonal_line
    diagonal_line += 1
    
diagonal_line -= 1
number_from_last_as_ruled = X + diagonal_line
number_from_second_last_as_ruled = diagonal_line - number_from_last_as_ruled + 1

print(f'{number_from_second_last_as_ruled}/{number_from_last_as_ruled}' if diagonal_line % 2 ==1 else f'{number_from_last_as_ruled}/{number_from_second_last_as_ruled}')