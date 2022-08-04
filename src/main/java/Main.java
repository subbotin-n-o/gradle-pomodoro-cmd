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
        System.out.println();

        long startTime = System.currentTimeMillis();
        timer(workTime, breakTime, ProgressBar.sizeBreak, ProgressBar.sizeWork);
        long endTime = System.currentTimeMillis();
        System.out.println("Таймер работал " + (endTime - startTime) / (1000 * 60) + " min");
    }

    public static void timer(int workTimeMin, int breakTimeMin, int sizeBreak, int sizeWork) throws InterruptedException {
        ProgressBar.printProgress("Work progress:: ", workTimeMin, sizeWork);
        ProgressBar.printProgress("Break progress:: ", breakTimeMin, sizeBreak);
    }
}