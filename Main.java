import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    File wbank=new File("words.csv");
    ArrayList<String> words=new ArrayList<String>();
    try (Scanner scan=new Scanner(wbank)) {
      while (scan.hasNext()) {
        words.add(scan.nextLine());
      }
    }
    try (Scanner scan=new Scanner(System.in)) {
      String cond="Yes";
      while(cond.equals("Yes")) {

        System.out.print("Enter your name: ");
        String name=scan.nextLine();
        System.out.println("Press Enter to begin the test!!");
        cond=scan.nextLine();
        if (!cond.equals("")) {
          System.exit(0);
        }
    
        String type="";
        for(int i=0;i<50;i++) {
          int ind=(int)(Math.random()*words.size());
          type+=words.get(ind)+" ";
        }
        type=type.trim();
        System.out.println("Begin!!\n"+type);
        ElapsedTime.start();

        String answer=scan.nextLine();
        int elapsed=(int) ElapsedTime.end().getSeconds();
        AccuracyScorer.Result result = AccuracyScorer.compare(type, answer, elapsed);
        Leaderboard.add(name, elapsed, result.accuracy, result.score);
        System.out.println("Do you want to play again?: Yes or No");
        cond=scan.nextLine();
      }
      Leaderboard.print();
    }
  }
}
