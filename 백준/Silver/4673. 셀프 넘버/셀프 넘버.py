import timeit


def kaprekar_number(n):
    return n + sum_digits(get_digit_number(n))


def get_digit_number(n):
    digits = [int(digit) for digit in str(n)]
    return digits


def sum_digits(digits):
    return sum(digits)


def get_self_number(kaprekar_numbers):
    for i in range(10000):
        if i not in kaprekar_numbers:
            print(i)


if __name__ == "__main__":
    start = timeit.default_timer()

    kaprekar_numbers = []
    [kaprekar_numbers.append(kaprekar_number(n)) for n in range(10000)]

    get_self_number(kaprekar_numbers)

    end = timeit.default_timer()

    # print(f"time : {end-start}")
