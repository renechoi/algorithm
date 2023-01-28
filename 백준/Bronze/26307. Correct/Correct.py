import sys
from datetime import datetime


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    HH, MM = map(int, input().split())
    
    start_time = datetime(year=2022, month=1, day=1, hour=9)
    
    end_time = datetime(year=2022, month=1, day=1, hour=HH, minute=MM)
    
    print((end_time - start_time).seconds // 60)
    