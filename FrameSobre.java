import javax.swing.*;
import java.awt.*;

public class FrameSobre extends FrameInterno{
	JTextArea area;

	public FrameSobre() {


	}

	public FrameSobre(int largura,int altura) {
		super(largura,altura, "Sobre");

		area = new JTextArea (10,30);
		area.setEditable(false);
		area.setFont(new Font("Serif", Font.BOLD, 15));

		area.append("Sobre \n\n\n");
		area.append("Programa desenvolvido por\n");
		area.append("Julio Cesar Siqueira\n\n");		
		area.append("Livre para distribuir e modificar a vontade\n\n");
		area.append("contato: jctsiqueira@gmail.com\n\n\n");
		area.append("twitter:@cesarsicas\n\n\n");



		painelInternoFrame = new JPanel();
		painelInternoFrame.add(area);
		

		//adiciona painel ao painel interno
		this.add(painelInternoFrame);

	}	
	

	protected void pegaValoresDigitados(){
		//vazio..
	}


}