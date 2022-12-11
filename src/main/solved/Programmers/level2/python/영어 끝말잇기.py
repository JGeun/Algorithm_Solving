def solution(n, words):
    wordStack = []
    index, order = 1, 0

    for word in words:
        if wordStack and (word in wordStack or word[0] != wordStack[-1][-1]):
            return [order+1, index]

        wordStack.append(word)

        order = ( order + 1 ) % n
        if order == 0:
            index += 1

    return [0, 0]