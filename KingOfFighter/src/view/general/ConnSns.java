package view.general;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

public class ConnSns {

	public void goSns(String name, String snsUrl) {
		// Create and run Chromium engine.
				Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1FT1B4D07Z1F2Q46NRAQ367AUJHQJ53FUJ9T4P9MI7VD6NU7YNYZJ2QF37NY4S").build());

				Browser browser = engine.newBrowser();
				// Load the required web page.
				browser.navigation().loadUrl(snsUrl);

				SwingUtilities.invokeLater(() -> {
					// Create Swing component for rendering web content
					// loaded in the given Browser instance.
					BrowserView view = BrowserView.newInstance(browser);

					// Create and display Swing app frame.
					JFrame frame = new JFrame(name+"ÀÇ SNS");
					// Close Engine and closing app frame.
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							engine.close();
						}
					});
					frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					frame.add(view, BorderLayout.CENTER);
					frame.setBounds(100, 100, 1300, 800);
					frame.setVisible(true);
				});
	}

}
