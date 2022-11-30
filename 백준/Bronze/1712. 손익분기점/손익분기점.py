def net_gain_with_variable_cost(B, C):
    return C - B


def is_cost_positive(cost):
    if cost <= 0:
        print(-1)
        return False
    return True


def get_break_even_point(net_gain_with_variable_cost, A):
    if is_cost_positive(net_gain_with_variable_cost) == True:
        break_even_point = A // net_gain_with_variable_cost
        print(break_even_point + 1)


if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    A, B, C = map(int, input().split())

    get_break_even_point(net_gain_with_variable_cost(B, C), A)

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
