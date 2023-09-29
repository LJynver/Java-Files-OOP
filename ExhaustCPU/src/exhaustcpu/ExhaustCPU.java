package exhaustcpu;

class TimeCount implements Runnable {
    int startCountdown = 720;
    public void run() {
        int hour, minute, second;
        while (startCountdown >= 0) {
            try {
                hour = startCountdown / 3600;
                minute = (startCountdown % 3600) / 60;
                second = startCountdown % 60;
                System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
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
        TimeCount t = new TimeCount();
        Thread st = new Thread(t);
        st.start();
    }
    
}
