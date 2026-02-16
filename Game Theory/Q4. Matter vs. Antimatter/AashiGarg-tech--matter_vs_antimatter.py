t = int(input())

for _ in range(t):
    s = input().strip()

    zeros = s.count('0')
    ones = s.count('1')

    moves = min(zeros, ones)

    if moves % 2 == 1:
        print("Positron")
    else:
        print("Negatron")
