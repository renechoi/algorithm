N = int(input())

pattern_commands = []

for file_name in zip(*[input() for _ in range(N)]) :
    
    if file_name.count(file_name[0]) == N :
        pattern_commands.append(file_name[0])
    else:
        pattern_commands.append('?')

print(''.join(pattern_commands))