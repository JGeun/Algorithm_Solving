package BOJ.Heewook.kakao.spring2021;


class Id {
  public static void main(String[] args) {
    System.out.println(new Id().solution("..."));
  }
  public String solution(String new_id) {

    // 1
    new_id = new_id.toLowerCase();

    // 2
    for (int i = 0; i < new_id.length(); i++) {
      char c = new_id.charAt(i);
      if (c != '.' && c != '_' && c != '-' && !Character.isLowerCase(c) && !Character.isDigit(c)) {
        new_id = new_id.substring(0, i) + new_id.substring(i + 1);
        i--;
      }
    }

    // 3
    while (new_id.indexOf("..") != -1)
      new_id = new_id.replace("..", ".");

    // 4
    if (new_id.length() > 0 && new_id.charAt(0) == '.')
      new_id = new_id.substring(1);
    if (new_id.length() >= 2 && new_id.charAt(new_id.length() - 1) == '.')
      new_id = new_id.substring(0, new_id.length() - 1);

    // 5
    new_id = new_id.length() == 0 ? "a" : new_id;

    // 6
    if (new_id.length() >= 16)
      new_id = new_id.substring(0, 15);
    if (new_id.charAt(new_id.length() - 1) == '.')
      new_id = new_id.substring(0, new_id.length() - 1);

    // 7
    if (new_id.length() <= 2) {
      int diff = 3 - new_id.length();
      String last = new_id.substring(new_id.length() - 1, new_id.length());
      new_id += last.repeat(diff);
    }

    return new_id;
  }

}
