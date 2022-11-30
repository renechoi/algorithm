

def get_digit_number(n):
    digits = [int(digit) for digit in str(n)]
    return digits


def get_difference(digits, idx):
    return int(digits[idx-1]) - int(digits[idx-2])


def get_digits_size(digits):
    return len(digits)


def is_common_difference_exist(digits, idx):
    while idx > 2:
        if get_difference(digits, idx) == get_difference(digits, idx-1):
            idx -= 1
        else:
            return False
    return True


if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    count = 0

    for number in range(int(input())):
        number += 1
        digits = get_digit_number(number)
        size = get_digits_size(digits)

        if size < 3:
            count += 1
            continue

        if is_common_difference_exist(digits, idx=size) == True:
            count += 1

    print(count)

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
