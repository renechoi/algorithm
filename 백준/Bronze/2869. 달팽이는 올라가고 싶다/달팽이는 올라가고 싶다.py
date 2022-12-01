
def snail_days(A, B, V):
    import math
    return math.ceil((V-A)/(A-B)+1)


if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    A, B, V = map(int, input().split())
    print(snail_days(A, B, V))

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
