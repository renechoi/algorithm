count=0
for i in range(int(input())):
    gifty = int(input()[2:])
    if gifty <= 90 :
        count+=1
        
print(count)