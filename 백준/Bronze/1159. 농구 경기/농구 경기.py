surnames = sorted([input()[0] for _ in range(int(input()))])

candidates = [surname for surname in set(surnames) if surnames.count(surname) >= 5]

print(''.join(sorted(candidates)) if len(candidates) > 0 else "PREDAJA")