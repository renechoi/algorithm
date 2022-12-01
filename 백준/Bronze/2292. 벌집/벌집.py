

if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    room = int(input())
    
    rooms, count = 1, 1
    
    while room > rooms:
        rooms += 6 * count
        count += 1
        
    print(count)
    

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
