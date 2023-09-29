package exhaustcpu;

class HelloRunner implements Runnable {
    int i;
    public void run() {
        i = 0;
        while (true) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(1); //the only thing added was this. the cpu usage stuck to 12% to 23%
            } catch (InterruptedException e) {
               System.out.println("Uh-oh, that was not good!"); //this did not appear though
            }
            //i++; this is the only code that stopped the infinite loop. but that's not necessary
            //after second execution, the CPU usage was not increased either way
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
