import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameJurosSimples extends FrameJuros{
	
	//formula para juros
	//Juros = Capital * taxa * tempo

	public FrameJurosSimples(){
		//construtor vazio
	}

	public FrameJurosSimples(int largura,int altura){
		super(largura,altura,"Juros Simples");
		

	}


	protected double calculaJuros(double capital,double taxa,int tempo){
			return capital*taxa*tempo;
	}


}