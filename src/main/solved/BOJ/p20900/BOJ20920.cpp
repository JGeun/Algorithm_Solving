#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

map<string, int> v;

bool compare(pair<string, int> &a, pair<string, int> &b) {
    if (a.second == b.second) {
        if (a.first.length() == b.first.length())
            return a.first < b.first;
        return a.first.length() > b.first.length();
    }
    return a.second > b.second;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int N, M;

    cin >> N >> M;
    while(N-->0) {
        string word;
        cin >> word;

        if (word.length() >= M) {
            v[word] ++;
        }
    }
    vector<pair<string, int>> vec(v.begin(), v.end());
    sort(vec.begin(), vec.end(), compare);
    for (auto p : vec) {
        cout << p.first << "\n";
    }
}
