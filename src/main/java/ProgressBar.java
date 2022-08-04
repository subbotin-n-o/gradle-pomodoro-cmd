import java.util.concurrent.TimeUnit;

class ProgressBar {
    static int sizeBreak = 30;
    static int sizeWork = 30;

    static void printProgress(String process, int time, int size) throws InterruptedException {
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
