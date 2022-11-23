N, M = map(int, input().split())

col = [0 for i in range(N)]
row = [0 for i in range(M)]

castle = [list(input()) for _ in range(N)]

for i in range(N):
    for j in range(M):
        if castle[i][j] == 'X':
            col[i] += 1
            row[j] += 1
            

if col.count(0) > row.count(0):
    print(col.count(0))
else:
    print(row.count(0))
