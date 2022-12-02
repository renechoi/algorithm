

if __name__ == "__main__":
    # import timeit
    # start = timeit.default_timer()

    word_list = [input() for word in range(int(input()))]

    set_word = list(set(word_list))

    sorted_word_list = [(len(i), i) for i in set_word]

    for len_word, word_list in sorted(sorted_word_list):
        print(word_list)

    # end = timeit.default_timer()
    # print(f"time : {end-start}")
