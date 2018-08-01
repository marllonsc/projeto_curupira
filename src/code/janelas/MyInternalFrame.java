package code.janelas;
import javax.swing.JInternalFrame;



public class MyInternalFrame extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public MyInternalFrame(String name) {
        super(name,
              false, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiabl
        setSize(747, 500);
        setResizable(false);
       
        //setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    }
}
