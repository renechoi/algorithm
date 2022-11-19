color_1 = input()
color_2 = input()
color_3 = input()

resistors = {'black': 0, 'brown': 1, 'red': 2, 
             'orange': 3, 'yellow': 4, 'green': 5, 
             'blue': 6, 'violet': 7, 'grey': 8, 'white': 9}
 
print((resistors[color_1] * 10 + resistors[color_2]) * (10 ** resistors[color_3]))
