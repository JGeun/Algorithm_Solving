def solution(polynomial):
    xCnt, constantCnt = 0, 0
    for poly in polynomial.split():
        if "x" in poly:
            if poly[0] == "x":
                xCnt += 1
            else:
                xCnt += int(poly[:poly.index("x")])
        elif poly == "+":
            continue
        else:
            constantCnt += int(poly)

    answer = ""
    if xCnt != 0:
        answer += str(xCnt) + "x" if xCnt > 1 else "x"
    if constantCnt != 0:
        if answer != "":
            answer += " + "
        answer += str(constantCnt)

    return answer