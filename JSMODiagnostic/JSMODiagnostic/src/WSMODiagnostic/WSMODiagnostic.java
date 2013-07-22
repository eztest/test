package WSMODiagnostic;
import JSMODiagnostic.Indice;
import JSMODiagnostic.JSMODiagnostic;
import java.awt.Color;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Fenêtre d'affichage principale. Contient le graphique des indicateurs
public class WSMODiagnostic extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dc ;

	public WSMODiagnostic(String title) 
	{
		super(title); 
		//calcul des bench et création du gaphique
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createBarChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 350));
		setContentPane(chartPanel);
					 
	}
	
	
	private CategoryDataset createDataset() 
	 {
		// Calcul des différents benchs
		// creation du tableau contenant les objets de type Indice
		Vector<Indice> vec=new Vector<Indice>();
		Vector<Indice> vect=new Vector<Indice>(); 
		JSMODiagnostic.ComputeBench(vec);
		JSMODiagnostic.DisplayBench( vect);	

		// Ici, le vecteur vec est rempli correctement avec les valeurs à afficher
		
		// Le vecteur renvoyé doit être mis dans un tableau de double comme attendu par le composant graphique
		
		// boucle de remplissage de datas
		
		double  [][] datas=new double [][]
				{
					{0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0},
				};
		
		for( int i = 0; i < 7; i++ )
		{
			Indice ind = (vec.get(i));
		    double val = ind.value(); 
			datas[0][i] = val;
		}

		for (int j =0; j<7; j++)
		{
		
			Indice ind2 = (vec.get(j));
			double ref = (ind2.ref()); 
			datas[1][j]= ref;
		}
		
		dc = new DefaultCategoryDataset(); 
	
		// Parcours des valeurs calculées et stockées dans vec.
		datas[0][1] = 100;
		
		
		for(int k =0; k<datas[0].length; k++)
		{
			Indice ind3 = (vec.get(k));
			String libel=(ind3.libelle());
			
			dc.addValue(datas[0][k], "This machine", String.format("%s", libel));
			
		}
		return DatasetUtilities.createCategoryDataset("reference", "indice ", datas);
	
	 }
	
	 private JFreeChart createBarChart(final CategoryDataset dataset)
	 {
		 final JFreeChart chart = ChartFactory.createStackedBarChart(
			  "WSMODiagnostic", "Bench", "%",
			  dc,   PlotOrientation.VERTICAL, true, true, false);
			
		 chart.setBackgroundPaint(new Color(249, 231, 236));
		
		 CategoryPlot plot = chart.getCategoryPlot();
		 plot.getRenderer().setSeriesPaint(0, new Color(0, 0, 255));
		 plot.getRenderer().setSeriesPaint(1, new Color(128, 0, 0));
		
		 return chart;
	 }
	 
	 public static void main (  final String[] args )
	 {
		
		Vector<Indice> vec=new Vector<Indice>();
		final WSMODiagnostic demo = new WSMODiagnostic("WSMODiagostic");		  
		demo.pack();	
		JSMODiagnostic.ComputeBench( vec);
		// Ici, le vecteur vec est rempli correctement avec les valeurs à afficher
		// Affichage en ligne de commande.
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true); 
	}	
}
