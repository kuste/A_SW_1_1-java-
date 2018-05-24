import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	
	private TextPanel txtPanel;
	private JButton clBtn;
	private ToolBar tlbar;
	private DataForm dataForm;
	
	public MainFrame() {
		
		setLayout(new BorderLayout());
		
		createCompMainFrame();
		add(clBtn = new JButton("click me"), BorderLayout.SOUTH);
		add(txtPanel,BorderLayout.CENTER);
		add(tlbar,BorderLayout.NORTH);
		add(dataForm,BorderLayout.WEST);
		activateComp();
		setSize(700,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void createCompMainFrame() {
		
		txtPanel = new TextPanel();
		tlbar = new ToolBar();
		dataForm = new DataForm();
	}
	
	public void activateComp() {
		
		clBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				txtPanel.writeText("Clicked :-)");
			}
		});
	
		tlbar.setToolBarListener(new ToolBarListener() {
			
			@Override
			public void writeFromFile(String str) {
				txtPanel.writeText(str);
			}
			
			@Override
			public void clearAllText() {
				txtPanel.clearTextArea();
			}
		
				
			
		});
		
		dataForm.setDataFormListener(new DataFormListener() {
			
			@Override
			public void dataEventOccured(DataFormEvent dfe) {
				 
				String name = dfe.getName();
				String city = dfe.getCity();
				String mail = dfe.getMail();
				
				txtPanel.writeText("Name: "+ name);
				txtPanel.writeText("City: "+ city);
				txtPanel.writeText("Mail: "+ mail);
				
			}
		});
		
	}

}










