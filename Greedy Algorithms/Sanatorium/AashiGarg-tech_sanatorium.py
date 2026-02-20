b, d, s = map(int, input().split())

max_val = max(b, d, s)

missed_b = max(0, max_val - 1 - b)
missed_d = max(0, max_val - 1 - d)
missed_s = max(0, max_val - 1 - s)

print(missed_b + missed_d + missed_s)