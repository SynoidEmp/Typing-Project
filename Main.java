import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
  {
    File wbank=new File("words.csv");
    ArrayList<String> words=new ArrayList<String>();
    try (Scanner scan=new Scanner(wbank)) {
      while (scan.hasNext()) {
        words.add(scan.nextLine());
      }
    }
    
    try (Scanner scan=new Scanner(System.in)) {
      System.out.println("Press Enter to begin the test!!");
      String cond=scan.nextLine();
      if (!cond.equals("")) {
        System.exit(0);
      }
    
      String type="";
      for(int i=0;i<50;i++) {
        int ind=(int)(Math.random()*words.size());
        type+=words.get(ind)+" ";
      }
      ElapsedTime.start();
      System.out.println("Begin!!\n"+type);

      String answer=scan.nextLine();

    System.out.println(ElapsedTime.end().getSeconds());
    }
  }
}