import sys

def get_input():
    return sys.stdin.readline()


def is_centre_and_r_equal(r1, r2, distance):
    return distance == 0 and r1 == r2


def is_inion_or_circumion(r1, r2, distance):
    return abs(r1-r2) == distance or r1 + r2 == distance


def is_overlap(r1, r2, distance):
    return abs(r1-r2) < distance < (r1+r2)


def calculate_distance(x1, y1, x2, y2):
    return math.sqrt((x1-x2)**2 + (y1-y2)**2)


def find_position(r1, r2, distance):
    return -1 if is_centre_and_r_equal(r1, r2, distance) else 1 if is_inion_or_circumion(r1, r2, distance) else 2 if is_overlap(r1, r2, distance) else 0


if __name__ == "__main__":
    import math

    for _ in range(int(get_input())):
        x1, y1, r1, x2, y2, r2 = map(int, input().split())
        distance = calculate_distance(x1, y1, x2, y2)

        print(find_position(r1, r2, distance))
