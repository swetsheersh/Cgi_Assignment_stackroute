package cgi_first_project;

public class TC_Iteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		while(a>1) {
			System.out.println("The value is :"+a);
			a-=1;
		}
		int b=10;
		do {
			System.out.println("The value is :"+b);
			b-=1;
		}while(b<1);
		
		for(int i=5;i>0;i--) {
			System.out.println("No of iteration is: "+i);
		}
	}

}
