total_price = int(input())
numbers = int(input())
sum = 0

for i in range(numbers):
    price, number = map(int, input().split())
    sum += price * number

print("Yes") if sum == total_price else print("No")