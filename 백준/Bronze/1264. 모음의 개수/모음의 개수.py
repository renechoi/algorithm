import sys


def get_input():
    return sys.stdin.readline()


if __name__ == "__main__":

    while True:
        string = str(input()).lower()
        if string == "#" :
            break

        vowel_detected = [x for x in string if x in ['a', 'e', 'i', 'o', 'u']]

        print(len(vowel_detected))

    