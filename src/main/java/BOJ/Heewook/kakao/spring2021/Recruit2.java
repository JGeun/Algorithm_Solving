package BOJ.Heewook.kakao.spring2021;

import java.util.ArrayList;
import java.util.HashMap;

class Recruit2 {

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

    @Override
    public String toString() {
      return this.lang + " " + this.job + " " + this.hist + " " + this.food + " " + this.score;
    }
  }

  public static void main(String[] args) {
    new Recruit2().solution(new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
        "python backend senior chicken 50" }, new String[] { "java and backend and junior and pizza 100" });

  }

  final static int LANG = 0;
  final static int JOB = 1;
  final static int HIST = 2;
  final static int FOOD = 3;
  final static int SCORE = 4;

  public int[] solution(String[] info, String[] query) {

    ArrayList<Person> persons = new ArrayList<>();
    int[] ret = new int[query.length];

    for (int i = 0; i < info.length; i++) {
      String[] oneInfo = info[i].split(" ");
      persons.add(new Person(oneInfo[0], oneInfo[1], oneInfo[2], oneInfo[3], oneInfo[4]));
    }

    HashMap<ArrayList<String>, ArrayList<Person>> map = new HashMap<>();

    for (int i = 0; i < query.length; i++) {
      String[] infos = query[i].replace("and ", "").split(" ");
      ArrayList<String> nowInfo = new ArrayList<>();
      for (int s = 0; s < infos.length; s++)
        nowInfo.add(infos[s]);
      ArrayList<Person> list = find(persons, 4, nowInfo, infos, map);
      
      for (Person p : list)
        System.out.println(p);
      ret[i] = list.size();
    }

    return ret;
  }

  private ArrayList<Person> find(final ArrayList<Person> persons, int index, ArrayList<String> nowInfo, String[] infos,
      HashMap<ArrayList<String>, ArrayList<Person>> map) {
    if (map.containsKey(nowInfo))
      return map.get(nowInfo);
    if (index == 0) {
      ArrayList<Person> ret = findPerson(persons, index, nowInfo.get(index));
      map.put(nowInfo, ret);
      return ret;
    }

    ArrayList<Person> target = find(persons, index - 1, new ArrayList<>(nowInfo.subList(0, nowInfo.size() - 1)), infos,
        map);
    target = findPerson(target, index, nowInfo.get(index));
    map.put(nowInfo, target);
    return target;
  }

  private ArrayList<Person> findPerson(ArrayList<Person> target, int index, String info) {

    ArrayList<Person> ret = new ArrayList<>();

    for (Person p : target) {
      switch (index) {
        case LANG:
          if (p.lang.equals(info))
            ret.add(p);
          break;
        case JOB:
          if (p.job.equals(info))
            ret.add(p);
          break;
        case HIST:
          if (p.hist.equals(info))
            ret.add(p);
          break;
        case FOOD:
          if (p.food.equals(info))
            ret.add(p);
          break;
        case SCORE:
          if (p.score >= Integer.valueOf(info))
            ret.add(p);
      }
    }
    return ret;
  }

}
