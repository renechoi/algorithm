N, m, M, T, R = map(int, input().split())
cnt = t = 0
current_m = m

while cnt < N:
    if m + T > M:
        break
    
    if current_m + T <= M:
        current_m += T
        cnt += 1
    
    else:
        current_m = max(current_m-R, m)
    
    t += 1

print(t if cnt == N else -1)