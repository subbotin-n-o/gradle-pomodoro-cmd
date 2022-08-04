import java.util.Scanner;

public class Main {
    // Input: --help
    // Output: Msg
    // Cmd: -w - сколько работать
    //      -b - сколько отдыхать
    //      --help - вызвать помощь
    // Input: -w 1 -b 1 -count 2 -m 2

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Добро пожаловать в приложение Pomodoro!!!\n" +
                           "Введите \"--help\" - для вызова справки");


        String[] userInput = new Scanner(System.in).nextLine().split(" ");

        // Всё время в минутах
        int workTime = 1;
        int breakTime = 1;

        int help = 0;
        int count = 1;
        int factor = 1;

        for (int i = 0; i < userInput.length; i++) {
            switch (userInput[i]) {
                case ("--help"):
                    System.out.println("\n" +
                            "Pomodoro - сделай свое время более эффективным\n" +
                            "-w - время работы, сколько хочешь работать.\n" +
                            "-b - время отдыха, сколько хочешь отдыхать.\n" +
                            "-count - количество итераций.\n" +
                            "--help - вызвать помощь\n");
                    help = 1;
                    break;

                case ("-w"):
                    workTime = Integer.parseInt(userInput[++i]);
                    break;

                case ("-b"):
                    breakTime = Integer.parseInt(userInput[++i]);
                    break;

                case ("-count"):
                    count = Integer.parseInt(userInput[++i]);
                    break;

                case ("-m"):
                    factor = Integer.parseInt(userInput[++i]);
                    break;
            }
        }

        if (help == 0) {
            long startTime = System.currentTimeMillis();

            for (int i = 1; i <= count; i++) {
                timer(workTime, breakTime, ProgressBar.sizeBreak, ProgressBar.sizeWork);
                workTime *= factor;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Pomodoro таймер истек: " + (endTime - startTime) / (1000 * 60) + " min");
        }
    }

    public static void timer(int workTimeMin, int breakTimeMin, int sizeBreak, int sizeWork) throws InterruptedException {
        ProgressBar.printProgress("Work progress:: ", workTimeMin, sizeWork);
        ProgressBar.printProgress("Break progress:: ", breakTimeMin, sizeBreak);
    }
}