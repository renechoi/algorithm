import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    for _ in range(3):
        numbers = []
        [numbers.append(int(get_input())) for j in range(int(get_input()))]

        print("+") if sum(numbers) > 0 else print("-") if sum(numbers) < 0 else print("0")
