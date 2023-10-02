arr = list(map(int, input().split()))

maxCnt = 0
num = 0
arr.sort(reverse=True)

for i in range(0, len(arr)):
    cnt = arr.count(arr[i])
    if maxCnt < cnt:
        num = arr[i]
        maxCnt = cnt

if maxCnt == 3:
    print(10000+1000*num)
elif maxCnt == 2:
    print(1000+100*num)
else:
    print(num*100)