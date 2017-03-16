package Model;

import java.util.ArrayList;

public class Cases {
	
	
	public static final int desert = 1 ; // jaune clair
	public static final int foret = 2 ; // vert foncé
	public static final int champ = 3 ;
	public static final int colline = 4 ;
	public static final int montagne = 5 ;
	
	protected int id ;
	protected int type ;
	protected int pion ;
	protected ArrayList<pieceConst> liste_colonies = new ArrayList<pieceConst>();
	
	public Cases(int id, int type, int pion)
	{
		this.id = id ;
		this.type = type ;
		this.pion = pion ;
		
	}

	public Cases() {
		// TODO Auto-generated constructor stub
		this.id = -1 ; 
		this.type = -1 ;
		this.pion = -1 ;
	}
	
	public void initialiser()
	{
		this.liste_colonies.add(null);
	}


}
