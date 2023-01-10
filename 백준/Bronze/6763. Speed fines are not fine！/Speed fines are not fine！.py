limit = int(input())
speed = int(input())
d = speed - limit

if d <= 0:
    print("Congratulations, you are within the speed limit!")
elif d >= 1 and d <= 20:
    print(f"You are speeding and your fine is ${100}.")
elif d >= 21 and d <= 30:
    print(f"You are speeding and your fine is ${270}.")
elif d >= 31:
    print(f"You are speeding and your fine is ${500}.")