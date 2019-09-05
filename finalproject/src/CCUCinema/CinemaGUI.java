package CCUCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class CinemaGUI implements ActionListener{
	private JFrame frame;
		
	public CinemaGUI(){
			frame=new JFrame();
			
		}
	void run(){
		
		ImageIcon img=new ImageIcon("C:/Users/tce/workspace/finalproject/ticket.png");
		frame.setIconImage(img.getImage());
		
		String[] price={"Select by price","10","20","30","40","50"};
		
		JPanel Panel1 = new JPanel();//set panel(small)
		JPanel mainPanel=new JPanel(new BorderLayout());//main panel(big)
		JComboBox combobox=new JComboBox(price);
		
		frame.setTitle("CCU★Cinema Seat Reservation");
		frame.setSize(700,550);	
		mainPanel.setBounds(10, 10, 650, 500);//set the bound of mainPanel
		
		
		//show the price of every seat
		Button ShowPrice=new Button("Show price");
		
		//add combobox to the north of the screen
		mainPanel.add(combobox,BorderLayout.NORTH);
		mainPanel.add(ShowPrice,BorderLayout.SOUTH);
		mainPanel.add(Panel1);
		frame.add(mainPanel);
		
		//set the layout for buttons
		Panel1.setLayout(new GridLayout(9, 10, 3, 3));
		
		//name for all of the button
		for(int i=1;i<=90;i++){
			String myButtonName="A"+i;
			if(i>10&&i<=20){			
				myButtonName="B"+(i-10);
			}
			if(i>20&&i<=30){
				myButtonName="C"+(i-20);
			}
			if(i>30&&i<=40){
				myButtonName="D"+(i-30);
			}
			if(i>40&&i<=50){
				myButtonName="E"+(i-40);
			}
			if(i>50&&i<=60){
				myButtonName="F"+(i-50);
			}
			if(i>60&&i<=70){
				myButtonName="G"+(i-60);
			}
			if(i>70&&i<=80){
				myButtonName="H"+(i-70);
			}
			if(i>80&&i<=90){
				myButtonName="I"+(i-80);
			}
			
			//new all the button, setActionCommand->use buttonName to distinguish buttons Ex.A1,B1
			//System.out.println(myButtonName);
			Button buttonName=new Button(myButtonName);
			Panel1.add(buttonName);
			buttonName.setActionCommand(myButtonName);
			buttonName.addActionListener(this);
			
		}	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	
		
		//show all seat price
		ShowPrice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tickets PricePrint=new Tickets();
				PricePrint.printPrices();//print out price table
						
			}
		});
		
		//Combobox ActionListener
		combobox.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String selectPrice=(String) combobox.getSelectedItem();
				
				//first item can't be selected
				if(selectPrice.equals("Select by price")){
					System.out.println("Can't be selected! Error!");
				}
				else{
					Tickets SelectedSeat=new Tickets();
					int seatPrice=Integer.parseInt(selectPrice);//turn selectPrice to Int
					SelectedSeat.SelectedByPrice(seatPrice);
					
				}					
			}
		});
		
		//call for the window adapter
		 frame.addWindowListener(new WindowAdapter() { 
             public void windowClosing(WindowEvent e) 
              {System.exit(0);}
             }); 
		 
	}//end of run() method
	
			Tickets seatTicket= new Tickets();
			//seat button click
			public void actionPerformed(ActionEvent e){
				
			
			String cmd=e.getActionCommand();
						
			int priceget=seatTicket.getPrice(cmd);
						
			boolean isSold=seatTicket.CheckSoldSeat(cmd);
			
			if(isSold==false){
			
					JOptionPane.showMessageDialog(frame,"Seat Name  :  "+cmd+"\n"+"Price : "+seatTicket.getPrice(cmd),
					"CCU★Cinema",JOptionPane.INFORMATION_MESSAGE);
	             			
					seatTicket.BuySeat(cmd);//buy the seat
					
					int option=JOptionPane.showConfirmDialog(frame,"Continuous? ","CCU★Cinema",
		                 JOptionPane.YES_NO_OPTION,
		                 JOptionPane.INFORMATION_MESSAGE); 
				   
				    if (option==JOptionPane.YES_OPTION) {
				    	frame.addWindowListener(new WindowHandler(frame));
				    }
				   
				    else if (option==JOptionPane.NO_OPTION) 
					{System.exit(0);}
			}
			else{//the seat is already sold
				
				JOptionPane.showMessageDialog(frame,"Sorry, this seat is unavailable!","CCU★Cinema",
						JOptionPane.ERROR_MESSAGE);
					
			}
			
			}//end of button actionListener
			
		class WindowHandler extends WindowAdapter {
				  JFrame f;
				  public WindowHandler(JFrame f) {this.f=f;}
		}
	
	}
		

