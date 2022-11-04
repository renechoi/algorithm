A = int(input())
B = int(input())

result_1 = A*(B%10)
result_2 = A*(B%100//10)
result_3 = A*(B//100)
result_4 = A*B

print(result_1, result_2, result_3, result_4, sep="\n")