package frontend;
import frontend.GraphicsDraw;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;


public class GraphicsMain extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public GraphicsMain() {
		initUI();
	}
	
	private void initUI(){
        final GraphicsDraw window = new GraphicsDraw();
        
        add(window);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                Timer timer = window.getTimer();
                timer.stop();
            }
        });
        setTitle("SUMMATIVE DEBATE");
        setSize(800, 600);
        setResizable(false);
        setFocusable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			GraphicsMain window = new GraphicsMain();
    			window.setVisible(true);
            }
        });
    }
}
