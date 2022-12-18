import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    while True :
        try :
            print(input())
        except EOFError:
            break