count_white = ""

for i in range(8):
    count_white += input()[i%2::2]
    
print(count_white.count("F"))