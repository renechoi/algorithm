chess_input = list(map(int,input().split()))
chess_origin = [1,1,2,2,2,8]
for i,j in zip(chess_input,chess_origin):
    print(j - i, end=' ')