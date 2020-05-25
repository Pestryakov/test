
public class MoveThread implements Runnable {
    private Thread self;
    private jGsme frame;
    private boolean canMove;
    private int delay;
    
    public MoveThread(jGsme frame,int delay){
        this.frame = frame;
        this.delay = delay;
        self = new Thread(this);
    }
    public int getDelay(){
        return delay;
    }
    public void setDelay(int delay){
        this.delay = delay;
    }
    public void start(){
        canMove = true;
        self.start();
    }
    public void stop(){
        canMove = false;
    }
    @Override
    public void run(){
      try{while(canMove){
          Thread.sleep(delay);
          frame.moveBox();
      }  
    }catch(InterruptedException ex){}
      
    }
    
}
