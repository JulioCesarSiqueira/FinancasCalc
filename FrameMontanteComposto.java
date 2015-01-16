import java.text.DecimalFormat;     

public class FrameMontanteComposto extends FrameMontante{
	
	public FrameMontanteComposto(){
		//construtor vazio
	}

	public FrameMontanteComposto(int largura,int altura){
		super(largura,altura,"Montante Composto");

	}

	protected double calculaMontante(double capital,double taxa,int tempo){
		double total;
		total = capital* Math.pow((taxa+1.0),tempo);		


		System.out.println("Taxa "+taxa);
		System.out.println("Tempo "+tempo);
		System.out.println("capital "+capital);

		System.out.println(total);
		

		return total;
		
	}
	

}