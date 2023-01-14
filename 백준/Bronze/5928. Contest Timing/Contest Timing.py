D, H, M = map(int, input().split())
time1 = D * 24 * 60 + H * 60 + M
time2 = 11 * 24 * 60 + 11 * 60 + 11
time = time1 - time2
if time < 0:
    print(-1)
else:
    print(time)