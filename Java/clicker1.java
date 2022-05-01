import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class clicker1 {
   private Robot d3;
   private Robot d9;
   public clicker1(){
        try{
        d3 = new Robot();
        d9 = new Robot();
        }catch (AWTException e){
            e.printStackTrace();
        }
    };
    public void autoclick(int speed){
        if (speed > 0) {
        d3.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        d3.delay(speed);
        d3.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);   
        }else{
        d3.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        d3.delay(1000);
        d3.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);   
        }
    }
    public void autopress(int spad, char keyss){
        if (spad > 0) {
        d9.keyPress(keyss);
        d9.delay(spad);
        d9.keyRelease(keyss);   
        }else{
            d9.keyPress(keyss);  
            d9.delay(1000);
            d9.keyRelease(keyss);  
        }
    }
}
