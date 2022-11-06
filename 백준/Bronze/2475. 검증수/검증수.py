numbers = list(map(int, input().split()))
answer = 0
for i in numbers:
    answer += i*i
    
print(answer % 10)