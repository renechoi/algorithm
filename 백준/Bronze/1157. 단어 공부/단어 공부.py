given_word = input().upper()
word_without_duplicate = [word for word in set(given_word)]

counts_list = [given_word.count(counts) for counts in word_without_duplicate]

answer = "?" if counts_list.count(max(counts_list)) > 1 else word_without_duplicate[counts_list.index(max(counts_list))]

print(answer)
