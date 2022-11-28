scores = [ list(map(int, input().split())) for _ in range(5)]

score_sum = [sum(scores[i]) for i in range(5)]

max_score = max(score_sum)

print(score_sum.index(max_score)+1, max_score)
