package BOJ.Heewook.kakao.spring2021;


import java.util.HashMap;


//효율성 테스트 실패
class Recruit {

  class Person {

    private String lang;
    private String job;
    private String hist;
    private String food;
    private int score;

    public Person(String lang, String job, String hist, String food, String score) {
      this.lang = lang;
      this.job = job;
      this.hist = hist;
      this.food = food;
      this.score = Integer.valueOf(score);
    }

    public boolean isTarget(String[] info) {
      if (!info[0].equals("-") && !this.lang.equals(info[0]))
        return false;
      if (!info[1].equals("-") && !this.job.equals(info[1]))
        return false;
      if (!info[2].equals("-") && !this.hist.equals(info[2]))
        return false;
      if (!info[3].equals("-") && !this.food.equals(info[3]))
        return false;
      if (!(this.score >= Integer.valueOf(info[4])))
        return false;
      return true;
    }

    @Override
    public String toString() {
      return this.lang + " " + this.job + " " + this.hist + " " + this.food + " " + this.score;
    }
  }

  public static void main(String[] args) {
    new Recruit().solution(new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
        "python backend senior chicken 50" }, new String[] { "java and backend and junior and pizza 100" });
  }

  public int[] solution(String[] info, String[] query) {

    Person[] persons = new Person[info.length];
    int[] ret = new int[query.length];

    for (int i = 0; i < info.length; i++) {
      String[] oneInfo = info[i].split(" ");
      persons[i] = new Person(oneInfo[0], oneInfo[1], oneInfo[2], oneInfo[3], oneInfo[4]);
    }
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < query.length; i++)
      ret[i] = find(persons, query[i].replace("and ", "").split(" "), map);

    return ret;
  }

  private int find(final Person[] persons, String[] info, HashMap<String, Integer> map) {
    int count = 0;
    for (Person p : persons)
      if (p.isTarget(info))
        count++;

    return count;
  }

}
