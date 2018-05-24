import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {

	private JButton clrBtn;
	private JButton readBtn;
	private ToolBarListener tbList;

	public ToolBar() {

		createComps();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(clrBtn);
		add(readBtn);
		activateComps();

	}

	private void createComps() {

		clrBtn = new JButton("clear");
		readBtn = new JButton("read file ...");

	}

	private void activateComps() {

		clrBtn.addActionListener(this);
		readBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		BufferedReader br;
		StringBuilder sb;

		if (ev.getSource() == clrBtn) {

			tbList.clearAllText();

		} else if (ev.getSource() == readBtn) {
			
			JFileChooser fc = new JFileChooser();
			int val = fc.showOpenDialog(this);
			
			if(val == JFileChooser.APPROVE_OPTION) {
				
				File file = fc.getSelectedFile();
				
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
					sb = new StringBuilder();
					String line;
					while((line = br.readLine()) != null) {
						sb.append(line);
						sb.append("\n");
					}
					
					br.close();
					
					tbList.writeFromFile(sb.toString());
					
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				System.out.println("Cancelled by User ...");
			}
			
			

		}

	}

	public void setToolBarListener(ToolBarListener lst) {
		this.tbList = lst;
	}

}
