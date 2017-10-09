package frontend;
import backend.DebateTimer;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;

public class GraphicsDraw extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private DebateTimer debateTime;
	private Timer timer;
	public JButton pause;
	public JButton skip;
	RenderingHints rh;
	Font font;
	public GraphicsDraw(){
		debateTime = new DebateTimer();
		
		timer = new Timer(1000, this);
        timer.start();
        
        pause = new JButton("Start Teams " + Integer.toString((new Random()).nextInt(8) + 1) + " and " + Integer.toString((new Random()).nextInt(8) + 1));
        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               debateTime.setting.switchPauseState();
               if(debateTime.setting.getPauseState()){
            	   pause.setText("Resume");
               }else{
            	   pause.setText("Pause");
               }
            }          
         });
        pause.setSize(200, 75);
        
        skip = new JButton("Skip");
        skip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               debateTime.setting.jumpUpdate();
            }          
         });
        skip.setSize(200, 75);
        
        rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        addKeyListener(new TAdapter());
        add(pause);
		add(skip);
	}
	public Timer getTimer(){
		return timer;
	}
	
	private class TAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e){
        }
        public void keyPressed(KeyEvent e){
        	System.out.println("life");
        }
    }
	
	private void doDrawing(Graphics g){
		//Declares
		Graphics2D G2D = (Graphics2D) g;
		G2D.setRenderingHints(rh);
		G2D.setFont(new Font("Helvetica", Font.BOLD, 50));
		
		//Button
		pause.setBounds(100, 505, 200, 75);
		skip.setBounds(500, 505 , 200, 75);
		//Divider
		G2D.setStroke(new BasicStroke(10));
		G2D.drawLine(0, 75, 800, 75);
		//Text
		G2D.drawString(debateTime.setting.getPrompt(), 400 - (g.getFontMetrics().stringWidth(debateTime.setting.getPrompt()) / 2), 50);
		G2D.drawString(debateTime.setting.getTime(), 400 - (g.getFontMetrics().stringWidth(debateTime.setting.getTime()) / 2), 500);
		//Countdown
		G2D.setFont(new Font("Helvetica", Font.BOLD, 325));
		G2D.drawString(debateTime.setting.getCountdown(), 400 - (g.getFontMetrics().stringWidth(debateTime.setting.getCountdown()) / 2), 375);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		repaint();
	}
}
