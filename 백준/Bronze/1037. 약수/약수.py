N = int(input())
divisor = list(map(int, input().split()))

max_value = max(divisor)
min_value = min(divisor)

print(max_value * min_value)