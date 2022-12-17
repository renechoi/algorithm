import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    a, b, c = map(int, input().split())

    print(a+b+c)