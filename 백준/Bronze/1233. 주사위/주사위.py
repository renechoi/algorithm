from itertools import product

S1, S2, S3 = map(int, input().split())

S1 = [i + 1 for i in range(S1)]
S2 = [i + 1 for i in range(S2)]
S3 = [i + 1 for i in range(S3)]

product = list(product(S1, S2, S3))

sum_of_dice_each= [sum(product[i]) for i in range(len(product))]
duplicates = {}

for lst in sum_of_dice_each:
    try:
        duplicates[lst] += 1
    except:
        duplicates[lst] = 1

print(max(duplicates, key=duplicates.get))