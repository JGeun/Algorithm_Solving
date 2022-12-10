def solution(people, limit):
    answer = 0

    people.sort()
    left, right = 0, len(people)-1

    while left < right:
        weightSum = people[left]

        while left < right and weightSum + people[right] > limit:
            answer += 1
            right -= 1

        left += 1
        answer += 1
        right -= 1

    if left == right:
        answer += 1

    return answer