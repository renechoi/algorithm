import sys
from datetime import datetime


def game():
    answer = 0
    
    while True:
        try:
            gum_gum = input()
            answer += 1
        except EOFError:
            break
    
    return answer

def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":
 
    print(game())