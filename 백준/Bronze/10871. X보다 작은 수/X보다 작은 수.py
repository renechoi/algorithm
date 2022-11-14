N, X = map(int, input().split())
array_A = list(map(int, input().split()))

for number in array_A:
    if number < X:
        print(number, end=" ")