#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio();
    cin.tie(nullptr);
    cout.tie(nullptr);

    int N, arrIdx = 0, num = 0;
    int *arr;

    cin >> N;
    arr = new int[N];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    stack<int> s;
    for (int i = 1; i <= N; i++) {
        if (!s.empty() && s.top() == i) {
            s.pop();
            num += 1;
            continue;
        }

        while (arrIdx < N && arr[arrIdx] != i) {
            s.push(arr[arrIdx++]);
        }

        if (arrIdx < N && arr[arrIdx] == i) {
            arrIdx += 1;
            num += 1;
        }
    }

    if (num == N) {
        cout << "Nice" << "\n";
    } else {
        cout << "Sad" << "\n";
    }
    return 0;
}
