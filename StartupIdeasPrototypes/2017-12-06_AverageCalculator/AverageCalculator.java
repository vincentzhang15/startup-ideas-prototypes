import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Average calculator
 * @author Vincent Zhang
 * @since December 6, 2017
 */ 
class AverageCalculator implements ActionListener
{
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	JTextField subjectLabel,assignmentname,markLabel,weightLabel,weightedaverageLabel,outputLabel;  
	JButton b1,b2;  
	
	int a = 75;
	int b = 7;
	int c = 150;
	int d = 20;

	public static void main(String[] args)
	{
		System.out.println("Hi this is main");
		AverageCalculator  averagecalculator = new AverageCalculator();
	}

	public AverageCalculator()
	{	   
		prep();
		subject();
		mark();

	}
	
	public void subject()
	{
		subjectLabel = new JTextField("Subject");  
		subjectLabel.setBounds(a,b,c,d);  

		mainFrame.add(subjectLabel);
	
	}
	public void mark()
	{

		b += 30;
		assignmentname = new JTextField("Assignment Name");  
		assignmentname.setBounds(a,b,c,d);  

		a += 200;
		markLabel = new JTextField("Mark");  
		markLabel.setBounds(a,b,c,d);  

		a += 200;
		weightLabel = new JTextField("Weight");  
		weightLabel.setBounds(a,b,c,d);  		

		
		a += 400;
		weightedaverageLabel = new JTextField("Weigted Average");  
		weightedaverageLabel.setBounds(a,b,c,d);  		
		weightedaverageLabel.setEditable(false);   
		
		outputLabel = new JTextField("Output");  
		outputLabel.setBounds(50,900,150,20);  
		outputLabel.setEditable(false);   

		a = 75;
		
		b1 = new JButton("Calculate");  
		b2 = new JButton("-");  

		
			System.out.println("came here");
		if (b >= 180)
		{
			System.out.println("came in 2");
			b1.setBounds(50,b+200,150,50);  
			b2.setBounds(220,b+200,50,50);  
		}
		else
		{
			System.out.println("came in 1");
			b1.setBounds(50,200,150,50);  
			b2.setBounds(220,200,50,50);  			
		}
		
		
		b1.addActionListener(this);  
		b2.addActionListener(this);  
	

		final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Peer");

		final JComboBox fruitCombo = new JComboBox(fruitsName);    
		fruitCombo.setBounds(150,200,5,5);  
		fruitCombo.setEditable(true);

		JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);    
		controlPanel.add(fruitListScrollPane);          
		
		

		mainFrame.add(subjectLabel);mainFrame.add(markLabel);mainFrame.add(weightLabel);mainFrame.add(weightedaverageLabel);mainFrame.add(outputLabel);
		mainFrame.add(assignmentname);
		mainFrame.add(b1);mainFrame.add(b2);
			
		mainFrame.setLayout(null);  
		mainFrame.setVisible(true);
	
	}
	public void prep()
	{
		mainFrame = new JFrame("Average Calculator");
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}        
		});
		
		headerLabel = new JLabel("", JLabel.CENTER);        
		statusLabel = new JLabel("",JLabel.CENTER);    
		statusLabel.setSize(350,100);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setSize(1000,1000);  
		
	}

	
 	public void actionPerformed(ActionEvent e)
	{  
		
		if(e.getSource() == b1)
		{  
			String s1 = markLabel.getText();  
			String s2 = weightLabel.getText();  
			
			double a = Double.parseDouble(s1);  
			double b = Double.parseDouble(s2);  
			double c = 0;  

			c=a*b;  
			
			String result = String.valueOf(c);  
			weightedaverageLabel.setText(result); 
			
		}
		else if(e.getSource()==b2)
		{  
//			mark(); 
			this.a = 75;
			this.b += 30;
			assignmentname = new JTextField("Assignment Name");  
			assignmentname.setBounds(this.a,this.b,this.c,this.d);  

		System.out.println("came333 here");
		if (b >= 180)
		{
			System.out.println("came111 in 2");
			b1.setBounds(50,b+40,150,50);  
			b2.setBounds(220,b+40,50,50);  
		}
		else
		{
			System.out.println("came222 in 1");
			b1.setBounds(50,200,150,50);  
			b2.setBounds(220,200,50,50);  			
		}
		
			this.a += 200;
			markLabel = new JTextField("Mark");  
			markLabel.setBounds(this.a,this.b,this.c,this.d);  

			this.a += 200;
			weightLabel = new JTextField("Weight");  
			weightLabel.setBounds(this.a,this.b,this.c,this.d);  		

			System.out.println(b);
			
			this.a += 400;
			weightedaverageLabel = new JTextField("Weigted Average");  
			weightedaverageLabel.setBounds(this.a,this.b,this.c,this.d);  		
			weightedaverageLabel.setEditable(false);   
						
			mainFrame.add(assignmentname);
			mainFrame.add(markLabel);
			mainFrame.add(weightLabel);
			mainFrame.add(weightedaverageLabel);
			
		}  
 
	} 
}