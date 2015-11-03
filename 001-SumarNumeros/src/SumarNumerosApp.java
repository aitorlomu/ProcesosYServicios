
public class SumarNumerosApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		int num1=sumarNumeros(1,50);
		int num2=sumarNumeros(51,100);
		int res=num1+num2;
		
		System.out.println(res);
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		
		
		time_start = System.currentTimeMillis();
		
		System.out.println(sumarNumeros(1,100));
		
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		
		
		
		
	}

	private static int sumarNumeros(int i, int j) {
		int sum=0;
		for(;i<=j;i++){
			sum=sum+i;
		}
		return sum;
	}

}
