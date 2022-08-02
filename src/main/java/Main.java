import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    // Input: --help
    // Output: Msg
    // Cmd: -w - сколько работать
    //      -b - сколько отдыхать
    //      --help - вызвать помощь
    // Input: -w 1 -b 1
//    public static int test = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите время для работы и отдыха");
        String[] userInput = new Scanner(System.in).nextLine().split(" ");

        // Всё время в минутах
        int workTime = 1;
        int breakTime = 1;

        int sizeBreak = 30;
        int sizeWork = 30;


        for (int i = 0; i < userInput.length; i++) {
            switch (userInput[i]) {
                case ("--help"):
                    System.out.println("\n" +
                            "Pomodoro - это приложение для улучшения личной эффективности.\n" +
                            "-w - сколько работать\n" +
                            "-b - сколько отдыхать\n" +
                            "--help - вызвать помощь\n");
                    break;

                case ("-w"):
                    workTime = Integer.parseInt(userInput[++i]);
                    break;

                case ("-b"):
                    breakTime = Integer.parseInt(userInput[++i]);
                    break;
            }
        }

        System.out.printf("workTime = %d, workBreak = %d", workTime, breakTime);

        long startTime = System.currentTimeMillis();
        timer(workTime, breakTime, sizeBreak, sizeWork);
        long endTime = System.currentTimeMillis();
        System.out.println("Таймер работал " + (endTime - startTime) / (1000 * 60) + " min");
    }

    public static void timer(int workTimeMin, int breakTimeMin, int sizeBreak, int sizeWork) throws InterruptedException {
        printProgress("Work progress:: ", workTimeMin, sizeWork);
        printProgress("Break progress:: ", breakTimeMin, sizeBreak);
    }

    private static void printProgress(String process, int time, int size) throws InterruptedException {
        int length;
        int rep;
        length = 60 * time / size;
        rep = 60 * time / length;
        int stretchb = size / (3 * time);
        for (int i = 1; i <= rep; i++) {
            double x = i;
            x = 1.0 / 3.0 * x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time * stretchb;
            double percent = (x / w) * 1000;
            x /= stretchb;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent + "% " + (" ").repeat(5 - (String.valueOf(percent).length())) + "[" + ("#").repeat(i) + ("-").repeat(rep - i) + "]    ( " + x + "min / " + time + "min )" + "\r");
            if (true) {
                TimeUnit.SECONDS.sleep(length);
            }
        }
        System.out.println();
    }
}