number = int(input())
title = 666
count = 0

while(True):
    if "666" in str(title) :
        count+=1
        if count == number :
            print(title)
            break
    title +=1