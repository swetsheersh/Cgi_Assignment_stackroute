package exception_cgi;

public class TC_Exception {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			throw new NumberFormatException("invalid");
			//System.out.println(5/0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("cannot be divided by zero");
		}
	}

}
