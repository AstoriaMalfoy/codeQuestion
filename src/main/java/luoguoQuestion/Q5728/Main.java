package luoguoQuestion.Q5728;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int countNumber = scanner.nextInt();
                List<Score> scores = new ArrayList<>();
                int result = 0;
                while(countNumber-->0){
                    Score s = new Score(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                    for (Score score : scores) {
                        if(s.isRes(score)){
                            result++;
                        }
                    }
                    scores.add(s);
                }
                System.out.println(result);
            }
            static class Score{
                int classA;
                int classB;
                int classC;

                public Score(int classA, int classB, int classC) {
                    this.classA = classA;
                    this.classB = classB;
                    this.classC = classC;
                }

                boolean isRes(Score s){
                    if(Math.abs(this.classA - s.classA) <=5
                    && Math.abs(this.classB - s.classB) <=5
                    && Math.abs(this.classC - s.classC) <=5
                    && Math.abs(this.classA - s.classA + this.classB - s.classB + this.classC - s.classC ) <=10){
                        return true;
                    }
                    return false;
                }
            }
        }
