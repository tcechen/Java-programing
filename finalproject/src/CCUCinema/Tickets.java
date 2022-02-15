package CCUCinema;

import java.awt.Button;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tickets {
	private int[][] prices = {
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
			{20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
			{20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
			{30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
		 };
	
	private ArrayList<String> soldSeat=new ArrayList<String>();
	
	public void printPrices()
		{
			String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
			System.out.println("Price table(the seat is unavailable when price is 0) ");
				for (String element : letters)
					{
					for (int i = 1; i <= 10; i++)
						{
							String seatName = element + i;
							int price = getPrice(seatName);
							String result = "(" + seatName + ")$" + price + " ";
							System.out.printf("%-9s", result);
						}
					System.out.println();
					}
				System.out.println();
		}

	private int getRowIndex(String seatName)
		{
			char letter = seatName.charAt(0);
			return letter - 65;
		}

	private int getColumnIndex(String seatName)
		{
			int length = seatName.length();
			if (length == 2)
			{
				char number = seatName.charAt(1);
				return number - 49;
			}
			else
			{
				return 9;
			}
		}

	/**
	 * use seatName search for the price
	 * @param seatName input from actionlistner
	 * @return price
	 */
	public int getPrice(String seatName)
		{
			int price = prices[getRowIndex(seatName)][getColumnIndex(seatName)];
			return price;
		}

	/**
	 * set the boughtTicket price to 0
	 * @param seatName input from actionlistner
	 */
	public void boughtTicket(String seatName)
		{
			prices[getRowIndex(seatName)][getColumnIndex(seatName)] = 0;
		}
	
	/**
	 * select the seat by price
	 * @param price price from combobox
	 */
	public void SelectedByPrice(int priceFromCombobox)
		{
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
			for (String element : letters)
				{
				for (int i = 1; i <= 10; i++)
					{
						String seatName = element + i;
						int price = getPrice(seatName);
						
						if(price==priceFromCombobox){
						
							prices[getRowIndex(seatName)][getColumnIndex(seatName)]=priceFromCombobox;
							String result = "(" + seatName + ")$" + price + " ";
							System.out.printf("%-9s", result);
							System.out.println();							
						}					
					}
				}
		}
	
	/**
	 * buy selected seat and add the arraylist
	 */
	public void BuySeat(String seatName){
		soldSeat.add(seatName);	
	}
	
	/**
	 * buy selected seat and add the arraylist
	 * @param isSold return whether the seat is sold or not
	 * @return isSold boolean
	 */
	public boolean CheckSoldSeat(String seatName){
		boolean isSold=false;
	
		for(int i=0;i<soldSeat.size();i++){
			isSold=soldSeat.get(i).equals(seatName);
		}
			
		return isSold;
	}
	
		}


