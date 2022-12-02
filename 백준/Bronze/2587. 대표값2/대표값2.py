

if __name__ == "__main__":

    import statistics 
    numbers = [int(input()) for _ in range(5)]
    numbers.sort()
    
    print(statistics.mean(numbers))
    print(numbers[2])
