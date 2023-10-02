#include<iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int *arr = new int[7];
    for (int i=0; i<3; i++) {
        int n;
        cin >> n;
        arr[n] += 1;
    }

    int maxCnt = 0, num;
    for (int i=6; i>=1; i--) {
        if (arr[i] > maxCnt) {
            maxCnt = arr[i];
            num = i;
        }
    }

    int res = 0;
    if (maxCnt == 3) {
        res = num*1000+10000;
    } else if (maxCnt == 2) {
        res = num*100+1000;
    } else {
        res = num*100;
    }

    cout << res << "\n";
}