package CCUCinema;



public class Main {

	public static void main(String[] args) {
		try{
			CinemaGUI gui=new CinemaGUI();
			gui.run();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
