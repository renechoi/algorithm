import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    while True:
        string = str(input())
        if string == "END" :
            break
        
        print(string[::-1])
        
   