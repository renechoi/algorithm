import sys


def get_input():

    return sys.stdin.readline()


if __name__ == "__main__":
    # input = sys.stdin.readline()

    map = [list(map(int, get_input().split()))
           for _ in range(int(get_input()))]

    map.sort(key=lambda x: (x[0], x[1]))

    [print(f"{coordinate[0]} {coordinate[1]}") for coordinate in map]
