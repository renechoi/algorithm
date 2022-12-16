import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    for _ in range(int(get_input())):
        string = input()
        print(f"{string[0]}{string[-1]}")