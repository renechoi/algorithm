from collections import Counter
import sys
        
def get_average(numbers):
   return round(sum(numbers) / len(numbers))

def get_median(numbers):
    return numbers[len(numbers) // 2]

def get_mode(numbers):
    mode = Counter(numbers).most_common(2)

    if len(numbers) > 1:
        if mode[0][1] == mode[1][1]:
            return mode[1][0]
        else:
            return mode[0][0]
    else:
        return mode[0][0]

def get_range(numbers):
    return max(numbers) - min(numbers)

if __name__ == "__main__":
    
    numbers = sorted([int(sys.stdin.readline()) for _ in range(int(sys.stdin.readline()))], reverse=False)

    print(get_average(numbers))
    print(get_median(numbers))
    print(get_mode(numbers))
    print(get_range(numbers))