package JSMODiagnostic;
public class BenchMethods
{
	static public int duration = 1000;
	public static void main(String args[]) 
	{
	}

//--------------------------------------------------------fonction CPUBench----------------------------------------------------------------------------------------------//
	public static long CPUBench( )
	{
		double x;
		double y; 
		double z;
		 
		long indexPerf = 0; // index de performance
		long elapsedTime = 0;  // Temps écoulé depuis le début du test (maintenant - date de début) 

		// Récupération de l'heure de lancement du test en ms
		long startTime = System.currentTimeMillis();

		// Boucle de calcul tant que 1000 msec ne se sont pas écoulées.
		do
		{
			x=123;
			y=23;
			z=x/y*12;
			z=z+y+x;
			
			// Comptage d'une nouvelle itéation
			indexPerf++; 
			// calcul du temps écoulé
			long endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			
		} while(elapsedTime < duration);
		
		return indexPerf;
		
	
	}
	//--------------------------------------------------------------fin CPUBench-----------------------------------------------------------------------------------------//
	
	public static long CPUMultiThreadedBench()
	{
		return 0;
		/*
		long indexPef7=0; 
		long elaspedTime =0;
		long startTime = System.currentTimeMillis();
		do
		{
			
			indexPef7++;
		}while(elaspedTime <1000);*/
		//return indexPerf7;
	}

	
	public static long Memory_tinyBench()
	{
		long indexPerf3=0; 
		long elaspedTime =0;
		long startTime = System.currentTimeMillis();
		do
		{
			byte[] buffer=new byte[20];
			buffer[0] = 2;
			indexPerf3++;
			long endTime = System.currentTimeMillis();
			elaspedTime=endTime - startTime; 
		}while(elaspedTime < duration);
		return indexPerf3;  
	}
	
	public static long Memory_mediunBench()
	{
		long indexPerf4=0; 
		long elaspedTime =0;
		long startTime = System.currentTimeMillis();
		
		do
		{
			byte[] buffer=new byte[8192];
			buffer[0] = 2; // dummy write
			
			indexPerf4++;
			long endTime = System.currentTimeMillis();
			elaspedTime=endTime - startTime; 
		}while(elaspedTime < duration);
		return indexPerf4;  
	}

	public static long Memory_largeBench()
	{

		long indexPerf5=0; 
		long elaspedTime =0;
		long startTime = System.currentTimeMillis();
		
		do
		{
			byte[] buffer=new byte[2000000];
			buffer[0] = 2;
			indexPerf5++;
			long endTime = System.currentTimeMillis();
			elaspedTime=endTime - startTime; 
		}while(elaspedTime < duration);
		return indexPerf5;
 
	}
	
	public static long   StringBench()
	{
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long elapsedTime = 0;
		long indexPerf2=0;
		String chaine1="a small one ";
		String chaine2 ="a longer string, but still a small one "; 
		String chaine3=" "; 
		
		do
		{
			chaine3+=chaine2;
			if(chaine3.indexOf(chaine1)!=-1)
			{	
				//System.out.println("chaine trouvée : " + chaine1.substring(0)+chaine3);
			}
			indexPerf2++;
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;

		} while(elapsedTime < duration );
		//System.out.println("index perf string : " + indexPerf2);
		return indexPerf2;
		
	}
	
	public static long regexpBench()
	{
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long elapsedTime = 0;
		long indexPerf6=0;
		String wip="172.15.320.15"; 
		String gip="172.16.20.40";
		String regexprip = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		
		/*
		Pattern g = Pattern.compile(gip); 
		Pattern w = Pattern.compile(wip);
		Matcher m1= g.matcher(regexprip); 
		Matcher m2= w.matcher(regexprip); 
		*/
			
		// chaine de 3 caractères
		// ex 'aze'=> Ok ex : 'ZA' => pas ok
		// Trouver l'expression régulière et la tester.

		
		do 
		{
			//System.out.print("l'adresse :" +wip+" est ");
			if ( wip.matches(regexprip) )
			{
				// afficher que l'adresse gip est valide
				//System.out.println(" valide ");
			}
			else 
			{
				// afficher que l'adresse gip n'est pas valide
				//System.out.println(" invalide ");
			}
			
			//System.out.print("l'adresse :" +gip+" est ");
			if ( gip.matches(regexprip) )
			{
				// afficher que l'adresse gip est valide
				//System.out.println(" valide ");
			}
			else 
			{
				// afficher que l'adresse gip n'est pas valide
				//System.out.println(" invalide ");
			}

			/*
			if ( g.matcher(regexprip)!=null)
			{
				// afficher que l'adresse gip est valide
				System.out.println("l'adresse :" +g+" est valide ");
			}
			else 
			{
				// afficher que l'adresse gip n'est pas valide
				System.out.println("l'adresse :" +g+" est invalide ");
			}
			if (w.matcher(regexprip)!=null)
			{
				System.out.println("l' adresse : "+w+" est invalide"); 
				
			}
			else 
			{
				System.out.println("ladresse : "+w+" est valide"); 
			}
			*/
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			indexPerf6++;
		} while(elapsedTime < duration );
		return indexPerf6; 
	}
}