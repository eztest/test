package WSMODiagnostic; 
import java.util.Vector;
import JSMODiagnostic.BenchMethods;
import JSMODiagnostic.Indice;

public class tableau 
{
	public static void main(String[] args) 
	{
		// ensemble des indicateurs à calculer et afficher.
				String indiceName[]={"CPU", "CPUMultiThreaded", "Memory_tiny",  "Memory_medium", "Memory_large", "String", "regexp"};
				long indicePerf[]={0, 12,68524350, 1062900, 5050, 5173, 94950}; 
				// creation du tableau contenant les objets de type Indice
				Vector<Indice> vec=new Vector<Indice>();
				
				long calculatedIndex;
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
					
//					Indice ind= new Indice(IndicePerf[i], calculatedPerf); 
					//indexPerformance=ext.callMethod();
					// ajout de l'objet au tableau
					vec.add(ind);
	}
}}
