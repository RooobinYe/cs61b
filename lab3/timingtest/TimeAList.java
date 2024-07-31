package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);

        TimeAList timeAList = new TimeAList();
        times.addLast(timeAList.timeDetect(1000));
        times.addLast(timeAList.timeDetect(2000));
        times.addLast(timeAList.timeDetect(4000));
        times.addLast(timeAList.timeDetect(8000));
        times.addLast(timeAList.timeDetect(16000));
        times.addLast(timeAList.timeDetect(32000));
        times.addLast(timeAList.timeDetect(64000));
        times.addLast(timeAList.timeDetect(128000));

        opCounts = Ns;

        printTimingTable(Ns, times, opCounts);
    }

    public double timeDetect(int num){
        Stopwatch sw = new Stopwatch();
        AList<Integer> timeDetect = new AList<>();
        for (int i = 0; i < num; i++){
            timeDetect.addLast(i);
        }
        return sw.elapsedTime();
    }
}