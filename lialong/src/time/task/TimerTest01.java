package time.task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
    private Timer timer;
    private int time;
    public TimerTest01(int time){
        timer = new Timer();
        this.time  = time;
        
        
    }
    
    public static void main(String[] args) {
        System.out.println("timer begin....");
        TimerTest01 test01 = new TimerTest01(1);
        test01.timer.schedule(new TimerTaskTest01(), new Date(),test01.time);
        test01.timer.schedule(new TimerTaskTest02(), new Date(),test01.time);
    }
}

class TimerTaskTest01 extends TimerTask{

    public void run() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("job1");
    }
}
class TimerTaskTest02 extends TimerTask{

    public void run() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("job2");
    }
}