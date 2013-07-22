package JSMODiagnostic;
public class Indice
{
	private  String name ; 
	private long value;	
	private long Indexref;
	private long perfRef; 
 
	

	// constructeur
	public Indice(String n, long PerfRef, long v, int duration )
	{ 
		// Hormonisation de l'indice sur une seconde (1000ms)
		perfRef=PerfRef*duration/1000;
		name=n; 
		value=v; 
		Indexref=v*100/perfRef;
	
		
		//nom=n2;
		//x=indexPerformance; 
	}

	// Récupération de la chaine représentant le couple, nom:valeur
	public String getString()
	{
		return name+" : "+value+" : "+ Indexref +" %"+";"; 
	}
	
	public double value()
	{
		return   Indexref; 

	}
	
	public double ref()
	{
		return perfRef;
	}
	
	public String libelle()
	{
		return name;
	}
	
}

