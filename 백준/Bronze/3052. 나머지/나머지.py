numbers = []
for _ in range(10):
    number = int(input())
    numbers.append(number % 42)
numbers = set(numbers)
print(len(numbers))