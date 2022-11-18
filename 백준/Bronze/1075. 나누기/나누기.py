N = int(input())
F = int(input())

digit_first = N // 100
answer = digit_first * 100

while answer % F != 0:
    answer += 1

print(str(answer)[-2:])