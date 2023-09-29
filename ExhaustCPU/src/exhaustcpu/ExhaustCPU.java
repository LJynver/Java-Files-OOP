package exhaustcpu;

class HelloRunner implements Runnable {
    int i;
    public void run() {
        i = 0;
        while (true) {
            System.out.println("Hello " + i);
            if (i == 50) {
                break;
            }
        }
    }
}

public class ExhaustCPU {

    public static void main(String[] args) {
        HelloRunner testThread = new HelloRunner();
        Thread a = new Thread(testThread);
        a.start();
        
    }
    
}
