package View;

public class Test_p {
	
	public static void main(String[] args)
	{
		int plateau[][] = {
				{ 0 , 1 , 1 , 1 , 0},
				{ 0 , 1 , 1 , 1 , 1},
				{ 1 , 1 , 1 , 1 , 1},
				{ 0 , 1 , 1 , 1 , 1},
				{ 0 , 1 , 1 , 1 , 0}
		};
		
		afficher(plateau);
	}
	
	public static void afficher(int[][] plat)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("   _  _  _  _  _") ;
			for(int j=0;j<5;j++)
			{
				String s = " ";
				//if(j%2==0)
				{
					if(plat[i][j]==0)
						s = "" + s ;
					else
						s = s + "/"+plat[i][j]+ "\\ " ;
				}
				System.out.print(s);
			}
			System.out.println();
		}
	}

}
