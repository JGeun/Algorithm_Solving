# 시간을 계산하면 되는 문제

H, M = map(int, input().split())
timer = int(input())

H += timer // 60
M += timer % 60

if M >= 60:
    M -= 60
    H += 1
if H >= 24:
    H -= 24

print(H, M)