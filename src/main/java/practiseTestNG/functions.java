package practiseTestNG;

public class functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		functions f = new functions();
		int c1 = f.cal();
		System.out.println(c1);
		
		f.reference(f);
		System.out.println("call by reference " +f);
		}

	public int cal() 
	{
		System.out.println("Cal method");
		int a= 10,b=20, c;
		c=a+b;
		System.out.println(c);
		return c;
	}
	
	public void reference(functions f2) 
	{
		System.out.println("call by reference " +f2);
	}
}
