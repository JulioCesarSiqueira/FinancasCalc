import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameMontanteSimples extends FrameMontante{

	//formula para Montante
	//montante = capital*(1+taxa.tempo)


	public FrameMontanteSimples(){
		//construtor vazio
	}

	public FrameMontanteSimples(int largura,int altura){
		super(largura,altura,"Montante Simples");

	}


	protected double calculaMontante(double capital,double taxa,int tempo){
		double total;

		total = capital*(1+(taxa*tempo));
		return total;
	}

	


}