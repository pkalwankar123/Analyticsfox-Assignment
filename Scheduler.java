C:\Program Files\Java\jdk1.8.0_171\bin\java.exe
-jar C:\Users\pkalwank\Desktop\expjar.jar

import java.util.concurrent.*;

import javax.swing.JOptionPane;

class Scheduler 
{
    private final ScheduledExecutorService service;
    private final long period = 1200;//Repeat interval
    public Scheduler()
    {
        service = Executors.newScheduledThreadPool(1);
    }
    public void startScheduler(Runnable runnable)
    {
        final ScheduledFuture<?> handler = service.scheduleAtFixedRate(runnable,0,period,TimeUnit.SECONDS);
        Runnable cancel = new Runnable()
        {
           
            public void run()
            {
                handler.cancel(true);
                System.out.println("5 minutes over...Task is cancelled : "+handler.isCancelled());
            }
        };
        service.schedule(cancel,1440,TimeUnit.MINUTES);
    }
    public static void main(String st[])
    {
        Runnable task = new Runnable()
        		
        {
        	
            public void run()
            {
            	infoBox("Dolyana Aram dya jara","Rest Time!!");
                
                
            }
        };
        Scheduler sc = new Scheduler();
        sc.startScheduler(task);
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}    