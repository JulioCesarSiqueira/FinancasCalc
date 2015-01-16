public class FrameJurosComposto extends FrameJuros{

	public FrameJurosComposto(){
		//vazio
	}

	public FrameJurosComposto(int largura,int altura){
		super(largura,altura,"Juros Composto");
	}
	
	//calcula juros composto
	protected double calculaJuros(double capital,double taxa,int tempo){
		double montante = capital* Math.pow((taxa+1.0),tempo);

		return montante - capital;
	}


}