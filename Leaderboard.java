import java.util.*;

public class Leaderboard {
    private static ArrayList<LeaderboardEntry> list = new ArrayList<LeaderboardEntry>();
    public static void add(String name, double time, double accuracy, int pts) {
        if(list.isEmpty()) {
            list.add(new LeaderboardEntry(name, time, accuracy,pts));
        }
        else if(list.get(0).pts<pts) {
            list.add(0,new LeaderboardEntry(name, time, accuracy, pts));
        }
        else if(list.get(list.size()-1).pts>pts) {
            list.add(new LeaderboardEntry(name, time, accuracy, pts));
        }
        else {
            for(int i=0;i<list.size();i++) {
                if(list.get(i).pts<=pts) {
                    list.add(i,new LeaderboardEntry(name, time, accuracy, pts));
            break;
                }
            }
        }
    }

    public static void print() {
        System.out.println("\n===== Leaderboard =====");

        for (int i = 0; i < list.size(); i++) {
            LeaderboardEntry l = list.get(i);
            System.out.println(l.name + " | Time: " + l.time + "s | Accuracy: " + l.accuracy + "%"+ " | " + l.pts + " points");
        }
    }

    static class LeaderboardEntry {
        String name;
        double time;
        double accuracy;
        int pts;

        public LeaderboardEntry(String name, double time, double accuracy, int pts) {
            this.name = name;
            this.time = time;
            this.accuracy = accuracy;
            this.pts = pts;
        }
    }
}

