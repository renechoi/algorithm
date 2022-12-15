import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    n1, k1, n2, k2 = map(int, get_input().split())
    print(n1*k1 + n2*k2)
