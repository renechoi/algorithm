def check_max(mid, max_length):
    if mid > max_length:
        max_length = mid
    return max_length


def binary_search(N, lines):
    low, high = 0, 10000000000
    max_length = 0

    while low <= high:
        mid = (low + high) // 2
        length = 0

        for line in lines:
            length += line//mid

        if length >= N:
            low = mid + 1
            max_length = check_max(mid, max_length)

        else:
            high = mid - 1

    return max_length


if __name__ == "__main__":
    K, N = map(int, input().split())
    lines = [int(input()) for _ in range(K)]

    print(binary_search(N, lines))
