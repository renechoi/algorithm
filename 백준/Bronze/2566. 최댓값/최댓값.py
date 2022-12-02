

if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    max_number = 0
    max_positionX = 0
    max_positionY = 0

    for i in range(9):
        board = list(map(int, input().split()))

        if max(board) > max_number:
            max_number = max(board)
            max_positionX = i
            max_positionY = board.index(max_number)

    print(max_number)
    print(max_positionX+1, max_positionY+1)

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
