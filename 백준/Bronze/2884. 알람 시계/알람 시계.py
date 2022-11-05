hour, minute = map(int, input().split())

if minute >= 45:
    print(hour, minute-45)
elif hour>0 and minute < 45:
    print(hour-1, minute+15)
else:
    print(23, minute+15)