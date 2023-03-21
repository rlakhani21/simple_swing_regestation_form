import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myFrame extends JFrame implements ActionListener
{
		//declaring essential components
		JLabel label1,label2,label3,label4,label5;
		JTextField t1,t2;
		JRadioButton male,female,other;
		JComboBox day,month,year;
		JTextArea ta1,screen;
		JCheckBox terms;
		JButton submit;
		JLabel msg;
		
		//defining or initializing the components here 
		myFrame()
		{
			setTitle("Regestration form (1):");
			setSize(800,500);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//creating container
			Container c= getContentPane();
			c.setLayout(null);
			
			//name
			label1 = new JLabel("Name : ");
			label1.setBounds(20,50,100,20);
			c.add(label1);
			
			t1 = new JTextField();
			t1.setBounds(130,50,100,20);
			c.add(t1);
			
			//mobile number
			label2 = new JLabel("Mobile Number : ");
			label2.setBounds(20,100,100,20);
			c.add(label2);
			
			t2 = new JTextField();
			t2.setBounds(130,100,100,20);
			c.add(t2);
			
			
			//gender
			label3 = new JLabel("Gender : ");
			label3.setBounds(20,150,100,20);
			c.add(label3);
			
			male = new JRadioButton("Male");
			male.setBounds(130,150,80,20);
			male.setSelected(true); 
			c.add(male);
		
		
			female = new JRadioButton("Female");
			female.setBounds(220,150,80,20);
			c.add(female);
			
			ButtonGroup gen = new ButtonGroup();
			gen.add(male);
			gen.add(female);
			
			//Date of Birth 
			label4 = new JLabel("Date Of Birth: ");
			label4.setBounds(20,200,100,20);
			c.add(label4);
			
			String	[]days= new String[31];
			for(int i = 0;i<=30;i++)
			{
				days[i] = Integer.toString(i+1);
			}
			
			String	[]years= new String[29];
			int y=2023;
			
			for(int i = 0;y>=1995;i++)
			{
				years[i] = Integer.toString(y);
				y--;
			}
			
			String []months={"Jan","Feb","Mar","Apr","May","June","Jul","Aug","Sept","Oct","Nov","Dec"};
			
			day = new JComboBox(days);
			month = new JComboBox(months);
			year = new JComboBox(years);
			
			day.setBounds(130,200,80,20);
			year.setBounds(220,200,80,20);
			month.setBounds(310,200,80,20);
			
			c.add(day);
			c.add(month);
			c.add(year);
			
			//address
			label5 = new JLabel("Addresss: ");
			label5.setBounds(20,250,100,20);
			c.add(label5);
			
			ta1 = new JTextArea();
			ta1.setBounds(130,250,200,50);
			c.add(ta1);
			
			//terms check box 
			terms = new JCheckBox("I Accept Terms & Conditions");
			terms.setBounds(130,310,200,20);
			c.add(terms);
			
			//submit button
			submit = new JButton("Submit");
			submit.setBounds(100,350,100,30);
			c.add(submit);
			
			//side screen
			screen = new JTextArea();
			screen.setBounds(410,50,300,300);
			c.add(screen);
			submit.addActionListener(this);
			
			//message
			msg = new JLabel("");
			msg.setBounds(20,380,500,30);
			c.add(msg);
			
			//setting background color
			c.setBackground(Color.cyan);
			
			setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(terms.isSelected())
			{
				msg.setText("Congratulations! you have successfully Registered");
				
				String name= t1.getText();
				String mobile= t2.getText();
				String gender = "male";
				if(female.isSelected())
				{
					gender = "female";
				}
				String dob=day.getSelectedItem()+"/"+month.getSelectedItem()+"/"+year.getSelectedItem();
				String address = ta1.getText();
			
				screen.setText("Name : "+ name + "\n"+
						"Mobile : "+ mobile+ "\n"+
						"Gender : "+ gender+ "\n"+
						"DOB : "+dob+ "\n"+
						"Address : "+address
				);
	
			}
			else
			{
				msg.setText("Please Accept the terms and conditions first ");
				screen.setText("");
			}
		}
}
class RegestrationForm 
{
		public static void main(String []args)
		{
			myFrame frame = new myFrame();
		}
}