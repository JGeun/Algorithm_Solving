#include<iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    int** arr = new int*[100];
    for (int i=0; i<100; i++) {
        arr[i] = new int[100];
        fill(arr[i], arr[i]+100, 0);
    }

    int n;
    cin >> n;
    while(n-->0){
        int a, b;
        cin >> a >> b;

        for (int i=a; i<a+10; i++) {
            for (int j=b; j<b+10; j++) {
                arr[i][j] += 1;
            }
        }
    }

    int res = 0;
    for (int i=0; i<100; i++) {
        for (int j=0; j<100; j++) {
            if (arr[i][j] != 0) {
                res += 1;
            }
        }
    }

    cout << res << "\n";
}
