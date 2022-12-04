import sys
import math


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    while True:
        A, B = map(int, get_input().split())

        if A == B == 0:
            break

        if A % B == 0:
            print("multiple")
        elif B % A == 0:
            print("factor")
        else:
            print("neither")
