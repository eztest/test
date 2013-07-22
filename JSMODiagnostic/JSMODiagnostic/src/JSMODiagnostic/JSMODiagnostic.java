package JSMODiagnostic;
import java.util.Vector;


public class JSMODiagnostic 
{
	
	public static void main(String[] args) 
	{
		// creation du tableau contenant les objets de type Indice
		Vector<Indice> vec=new Vector<Indice>();
		
		ComputeBench(vec);
		// Ici, le vecteur vec est rempli correctement avec les valeurs à afficher
		
		// Affichage en ligne de commande.
		DisplayBench(vec);
	}
	
	public static void ComputeBench(Vector<Indice> vec)
	{
		// ensemble des indicateurs à calculer et afficher.
		String indiceName[]={"CPU", "CPUMultiThreaded", "Memory_tiny",  "Memory_medium", "Memory_large", "String", "regexp"};
		long indicePerf[]={ 68430400, 12,68524350, 1062900, 5050, 5173, 94950}; 
		
		long calculatedIndex;
		//long calculatedPerf;  
		// Création et ajout au tableau des objets représentant les indices
		// parcours des labels
		for( int i=0; i<indiceName.length; i++)
		{
			// System.out.println(indiceName[i]+" "); 
			// Création de l'objet
			if ( indiceName[i] == "CPU" )
				calculatedIndex = BenchMethods.CPUBench();
			else if ( indiceName[i] == "CPUMultiThreaded" )
				calculatedIndex  = BenchMethods.CPUMultiThreadedBench();
			else if (indiceName[i]== "Memory_tiny" )
				calculatedIndex = BenchMethods.Memory_tinyBench(); 
			else if (indiceName[i]== "Memory_medium" )
				calculatedIndex= BenchMethods.Memory_mediunBench();
			else if (indiceName[i]=="Memory_large")
				calculatedIndex=BenchMethods.Memory_largeBench(); 
			else if(indiceName[i]=="String")
				calculatedIndex=BenchMethods.StringBench();
			else if(indiceName[i]=="regexp")
				calculatedIndex=BenchMethods.regexpBench(); 
			else
				calculatedIndex = 0;
		
			Indice ind = new Indice( indiceName[i], indicePerf[i], calculatedIndex, BenchMethods.duration);
			
//			Indice ind= new Indice(IndicePerf[i], calculatedPerf); 
			//indexPerformance=ext.callMethod();
			// ajout de l'objet au tableau
			vec.add(ind);
		}

	}
	
	public static void DisplayBench(Vector<Indice> vect)
	{
		// Parcours pour affichage de l'ensemble des couples nom/valeurs d'indice
		//System.out.print(""); 
		//System.out.println("");
		System.out.print("{"); 
		for( int i=0; i < vect.size(); i++)
		{
			//String str = String.format("%d", vec.get(i));
			Indice ind = (Indice)vect.get(i);
			System.out.print(ind.getString() + " "); 
		}
		
		System.out.print("}"); 
		System.out.println(" ");
	}
			
}