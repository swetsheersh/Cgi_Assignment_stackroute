package exception_cgi;

public class MyExceptinMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Emp emp=new Emp();
			emp.getDetails();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			System.out.println("Thanks...");
		}

	}

}
