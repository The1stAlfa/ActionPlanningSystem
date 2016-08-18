package Interface;

import com.sun.awt.AWTUtilities;
import javax.swing.*;
import java.awt.*;

public class SplashWindow extends JWindow{

	private static final long serialVersionUID = 1L;

	public SplashWindow(String filename, Frame f, int waitTime)
	{
		super(f);
                JLabel l = new JLabel(new ImageIcon(filename));
                AWTUtilities.setWindowOpaque(this,false);
		getContentPane().add(l, BorderLayout.CENTER);
                pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = l.getPreferredSize();
		setLocation(screenSize.width/2 - (labelSize.width/2),screenSize.height/2 - (labelSize.height/2));

		final int pause = waitTime;
		final Runnable closerRunner = new Runnable()
		{
			public void run()
			{
				setVisible(false);
				dispose();
			}
		};
		
		Runnable waitRunner = new Runnable()
		{
			public void run()
			{
				try
				{
					Thread.sleep(pause);
					SwingUtilities.invokeAndWait(closerRunner);
				}
				catch(Exception e)
				{
					e.printStackTrace();
		
				}
			}
		};
		setVisible(true);
		Thread splashThread = new Thread(waitRunner, "SplashThread");
		splashThread.start();
	}	
}
