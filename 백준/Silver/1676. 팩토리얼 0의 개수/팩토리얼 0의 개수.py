import sys
import math


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    N = int(get_input())

    print(N//5 + N//25 + N//125)
