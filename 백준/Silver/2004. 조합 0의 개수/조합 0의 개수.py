import sys
import math


def get_input():
    return sys.stdin.readline()


def count_two(n):
    two = 0
    while n != 0:
        n = n // 2
        two += n

    return two


def count_five(n):
    five = 0
    while n != 0:
        n = n // 5
        five += n

    return five


if __name__ == "__main__":

    n, m = map(int, get_input().split())

    count_two = count_two(n) - count_two(n - m) - count_two(m)
    count_five = count_five(n) - count_five(n - m) - count_five(m)

    print(min(count_two, count_five))
