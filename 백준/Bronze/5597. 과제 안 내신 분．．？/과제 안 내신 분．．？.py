n = [number for number in range(1,31)]
for _ in range(28):
    n.remove(int(input()))
print(*n, sep="\n")