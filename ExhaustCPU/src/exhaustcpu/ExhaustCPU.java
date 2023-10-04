package exhaustcpu;

class TimeCount implements Runnable {
    int startCountdown = 720;
    private boolean timeRun = true;
    int hour, minute, second;
    
    public TimeCount() { //start to 12 minutes
        this.hour = startCountdown / 3600;
        this.minute = (startCountdown % 3600) / 60;
        this.second = startCountdown % 60;
    }
    
    public void run() {
        while (startCountdown >= 0) {
            if (timeRun) {
                hour = startCountdown / 3600;
                minute = (startCountdown % 3600) / 60;
                second = startCountdown % 60;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Time error!");
                }
                this.startCountdown--;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Time error!");
                }
            }
        }
    }
    
    public void stopTimer() {
        timeRun = false;
    }
    
    public void resumeTimer() {
        timeRun = true;
    }
}

public class ExhaustCPU {

    public static void main(String[] args) {
        
        TimeCount time1 = new TimeCount();
        Thread timeThread =  new Thread(time1);
        timeThread.start();
        
        while (time1.second >= 0) {
            try {
                System.out.printf("%02d:%02d:%02d\n", time1.hour, time1.minute, time1.second);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        }
        
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        time1.stopTimer();
//        
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        time1.resumeTimer();
       
    }
    
}
