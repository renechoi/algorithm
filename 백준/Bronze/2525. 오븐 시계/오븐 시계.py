current_hour, current_minute = map(int, input().split())
minute_takes = int(input())

hours = int(current_hour + ( (current_minute + minute_takes) // 60 ) )  % 24    
minutes = (current_minute + minute_takes)%60
print(hours, minutes)
