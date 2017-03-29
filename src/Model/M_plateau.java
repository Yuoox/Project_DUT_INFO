package Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;

public class M_plateau extends Cases{
	
	public ArrayList<Point> liste_coordonnees_colo = new ArrayList<Point>();
	public ArrayList<JLabel> liste_colo = new ArrayList<JLabel>();
	public ArrayList<String> list_couleur_colo = new ArrayList<String>();
	public ArrayList<Point> liste_coordonnees_route = new ArrayList<Point>();
	public ArrayList<JLabel> liste_route = new ArrayList<JLabel>();
	public ArrayList<String> liste_couleur_route = new ArrayList<String>();
	public ArrayList<Integer> liste_orientation_route = new ArrayList<Integer>();
	private Cases[][] plateau =new Cases[5][5];/* = {
			{null, new Cases(),new Cases(), new Cases(), null},
			{null, new Cases(), new Cases(), new Cases(), new Cases()},
			{new Cases(), new Cases(), new Cases(10,5,-1), new Cases(), new Cases()},
			{null, new Cases(), new Cases(), new Cases(), new Cases()},
			{null, new Cases(), new Cases(), new Cases(), null}
	};*/
	
	public M_plateau()
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
				plateau[i][j] = new Cases();
		}
		plateau[2][2] = new Cases(10,5,-1);
	}
	
	public static int alea(int min, int max)
	{
		Random r = new Random();
		return min + r.nextInt(max+1 - min);
	}
	
	public void editer_pion(int x,int y, int val)
	{
		try
		{
		plateau[x][y].pion = val ;
		}
		catch(Exception e)
		{
		System.out.println("x : " + ", y : " + "exception : " + e);}
	}
	
	public void editer_cases(int x,int y, int val)
	{
		this.plateau[x][y].type = val ;

	}
	
	// permet de savoir quel territoire produisent de la matière première
	public ArrayList<Integer> resultat_des(int pos){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(plateau[i][j].pion==pos)
				{
					int val = plateau[i][j].type ;
					String cases = "" ;
					switch(val)
					{
						case 1 : cases = "pature" ; break ;
						case 2 : cases = "foret" ; break;
						case 3 : cases = "champ" ; break;
						case 4 : cases = "colline" ;break;
						case 5 : cases = "montagne" ;break;
					}
					System.out.println("c'est l'élement **" + cases + "** qui produit");
				}
			}
		}
		return null; 
	}
}
