number = int(input())

print(-1 if number in [1,2,4,7] else number // 5 + number % 5 - number % 5 // 3 * 2)