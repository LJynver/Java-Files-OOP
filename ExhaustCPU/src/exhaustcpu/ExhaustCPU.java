package exhaustcpu;

//class HelloRunner implements Runnable {
//    int i;
//    public void run() {
//        i = 0;
//        while (true) { //this can also be implemented as a for loop also
//            System.out.println("Hello " + i);
//            try {
//                Thread.sleep(1); //the only thing added was this. the cpu usage stuck to 12% to 23%
//            } catch (InterruptedException e) {
//               System.out.println("Uh-oh, that was not good!"); //this did not appear though
//            }
//            //i++; this is the only code that stopped the infinite loop. but that's not necessary
//            //after second execution, the CPU usage was not increased either way
//        }
//    }
//}

class TimeCount implements Runnable {
    int startCountdown = 720;
    public void run() {
        int hour, minute, second;
        while (startCountdown >= 0) {
            hour = startCountdown / 3600;
            minute = (startCountdown % 3600) / 60;
            second = startCountdown % 60;
            System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Time error!");
            }
            this.startCountdown--;
        }
    }
}

public class ExhaustCPU {

    public static void main(String[] args) {
//        HelloRunner testThread = new HelloRunner();
//        Thread a = new Thread(testThread);
//        a.start();
        TimeCount t = new TimeCount();
        Thread st = new Thread(t);
        st.start();
    }
    
}
