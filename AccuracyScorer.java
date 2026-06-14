public class AccuracyScorer {

    public static class Result {
        public final int correctChar;
        public final int totalChar;
        public final double accuracy;
        public final int score;

        public Result(int correctWords, int totalChar, double accuracy, int score) {
            this.correctChar = correctWords;
            this.totalChar = totalChar;
            this.accuracy = accuracy;
            this.score = score;
        }
    }
    
    public static Result compare(String target, String typed, long timeSeconds) {
        int correct=0;
        if (target.equals(typed)) {
            correct=typed.length();
        }
        else if(typed.length()!=0) {
            String c=target;
            if(target.length()>typed.length()) c=typed;
            for (int i=1;i<c.length();i++) {
                if(target.substring(i-1,i).equals(typed.substring(i-1,i))) {
                    correct++;
                }
            }
        }
        
        double accuracy=0;
        if (!(typed.length()==0)) {
            accuracy = (double) correct / target.length();
        }
        System.out.println(correct+"/"+target.length()+"="+accuracy);
        int score = (int) Math.max(0.0,((600.0 - timeSeconds) * accuracy));
        accuracy=accuracy*100;
        return new Result(correct, target.length(), accuracy, score);
    }
}