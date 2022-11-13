N = int(input())
number_for_calculation = N
count = 0

while True:
    a = number_for_calculation // 10 
    b = number_for_calculation % 10 
    c = (a + b) % 10 #8
    number_for_calculation = (b * 10)+c #68
    
    count+=1
    if(number_for_calculation==N):
        break

print(count)