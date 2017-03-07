package Model;

import java.util.Arrays;
import java.util.Random;

public class M_plateau {

	public static final int desert = 1 ;
	public static final int foret = 2 ;
	public static final int champ = 3 ;
	public static final int colline = 4 ;
	public static final int montage = 5 ;
	
	private int plateau_pion[][] = {
			{ 0 , 1 , 1 , 1 , 0},
			{ 0 , 1 , 1 , 1 , 1},
			{ 1 , 1 , 1 , 1 , 1},
			{ 0 , 1 , 1 , 1 , 1},
			{ 0 , 1 , 1 , 1 , 0}
	};
	
	private int plateau_cases[][] = {
			{ 0 , -1 , -1 , -1 , 0},
			{ 0 , -1 , -1 , -1 , 1},
			{ -1 , -1 , desert , -1 , -1},
			{ 0 , -1 , -1 , -1 , 1},
			{ 0 , -1 , -1 , -1 , 0}
	};
	/*
	private int coordonnees[][]
			{ -1, -1, 332, 462, 592,-1},
			{ -1, 266, 396, 526, 656, -1},
			{ 197, 330, 465, 595,724
			};
	*/
	public static int alea(int min, int max)
	{
		Random r = new Random();
		return min + r.nextInt(max+1 - min);
	}
	
	public void editer_pion(int x,int y, int val)
	{
		plateau_pion[x][y] = val ;
	}
	
	public void editer_cases(int x,int y, int val)
	{
		this.plateau_cases[x][y] = val ;
		//System.out.println("[" + this.plateau_cases[0][1] + "]-[" + this.plateau_cases[0][2] + "]-[" + + this.plateau_cases[0][3] + "]");
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "M_plateau [plateau_pion=" + Arrays.toString(plateau_pion) + ", plateau_cases="
				+ Arrays.toString(plateau_cases) + "]";
	}
}
