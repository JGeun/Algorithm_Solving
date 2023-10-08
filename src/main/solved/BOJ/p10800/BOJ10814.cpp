#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b) {
    return a.first < b.first;
}

int main() {
    ios_base::sync_with_stdio();
    cin.tie(nullptr);
    cout.tie(nullptr);

    int N;
    pair<int, string> tmp;
    vector<pair<int, string>> arr;

    cin >> N;
    for (int i=0; i<N; i++) {
        cin >> tmp.first >> tmp.second;
        arr.push_back(tmp);
    }
    stable_sort(arr.begin(), arr.end(),compare);
    for (int i=0; i<N; i++) {
        cout << arr[i].first << ' ' << arr[i].second << "\n";
    }
}
