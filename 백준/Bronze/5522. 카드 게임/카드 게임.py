import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    score = 0
    for _ in range(5):
        score += int(get_input())
    print(score)
