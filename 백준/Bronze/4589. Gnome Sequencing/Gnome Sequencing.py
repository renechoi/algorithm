import sys

def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":
 
    N = int(input())
    arrs = [list(map(int, input().split())) for _ in range(N)]
    print("Gnomes:")

    for arr in arrs:
        print("Ordered") if (arr == sorted(arr) or arr == sorted(arr, reverse=True) ) else print("Unordered")

