def solution(s):
    input = s.split()
    stack = []

    for ch in input:
        if ch == "Z":
            stack.pop()
        else:
            stack.append(ch)

    answer = 0

    while stack:
        answer += int(stack.pop())

    return answer