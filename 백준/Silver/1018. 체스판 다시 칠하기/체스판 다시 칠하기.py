N, M = map(int, input().split())
board = [input() for _ in range(N)]

color = {0: "B", 1: "W"}
count = []

## 완전 탐색 알고리즘으로 모든 가능성을 탐색한다 

for x_start in range(N - 7):
    for y_start in range(M - 7):

        paint_white, paint_black, total_paint = 0, 0, 0

        for x in range(x_start, x_start + 8):
            for y in range(y_start, y_start + 8):
                if board[x][y] != color[(x + y) % 2]:
                    paint_black += 1
                else:
                    paint_white += 1
                    
        total_paint = min(paint_black, paint_white)
        count.append(total_paint)

print(min(count))