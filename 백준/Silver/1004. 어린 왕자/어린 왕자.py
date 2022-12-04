import sys
import math


def get_input():
    return sys.stdin.readline()


def calculate_distance(x1, x2, y1, y2):
    return (x1-x2)**2 + (y1-y2)**2


def is_both_coordiantes_inside_planet(planet_r, distance_btw_start, distance_btw_end):
    return planet_r > distance_btw_start and planet_r > distance_btw_end


def is_at_least_one_outside_planet(planet_r, distance_btw_start, distance_btw_end):
    return planet_r > distance_btw_start or planet_r > distance_btw_end


def calculate_entry_and_exit(start_x, start_y, end_x, end_y):
    count = 0
    
    for _ in range(int(get_input())):
        planet_x, planet_y, planet_r = map(int, input().split())

        planet_r = planet_r**2
        
        distance_btw_start = calculate_distance(
            start_x, planet_x, start_y, planet_y)
        distance_btw_end = calculate_distance(
            end_x, planet_x, end_y, planet_y)

        if is_both_coordiantes_inside_planet(planet_r, distance_btw_start, distance_btw_end):
            pass
        elif is_at_least_one_outside_planet(planet_r, distance_btw_start, distance_btw_end):
            count += 1

    return count


if __name__ == "__main__":

    for _ in range(int(get_input())):
        start_x, start_y, end_x, end_y = list(map(int, get_input().split()))

        print(calculate_entry_and_exit(start_x, start_y, end_x, end_y))
