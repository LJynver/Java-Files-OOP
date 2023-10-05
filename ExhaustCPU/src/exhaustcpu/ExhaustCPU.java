package exhaustcpu;

class TimeCount implements Runnable {
    protected int startCountdown;
    protected boolean timerState = true;
    protected int hour, minute, second;
    
    public TimeCount() { //constructor to set it to 
        this.startCountdown = 720;
        countTheTime();
    }
    
    public void run() {
        while (startCountdown >= 0) {
            if (timerState) {
                try {
                    countTheTime();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Time error!");
                }
                this.startCountdown--;
            } else {
                try {
                    Thread.sleep(1000);
                    System.out.println("On hold!");
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong!");
                }
            }
        }
    }
    
    public void countTheTime() {
        this.hour = startCountdown / 3600;
        this.minute = (startCountdown % 3600) / 60;
        this.second = startCountdown % 60;
    }
    
    public void resetTimer() {
        this.timerState = false;
        this.startCountdown = 720;
        this.timerState = true;
    }
    
    public void stopTimer() {
        this.timerState = false;
    }
    
    public void resumeTimer() {
        this.timerState = true;
    }
}

public class ExhaustCPU {

    public static void main(String[] args) {
        
        TimeCount time1 = new TimeCount();
        Thread timeThread =  new Thread(time1);
        timeThread.start();
        
        while (time1.timerState) {
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time1.stopTimer();
            
//            try {
//                System.out.printf("%02d:%02d:%02d\n", time1.hour, time1.minute, time1.second);
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println("Something went wrong!");
//            }
        }
       
    }
    
}
