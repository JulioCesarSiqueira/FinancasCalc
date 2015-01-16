import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public abstract class FrameInterno extends JInternalFrame {
	public static int posicaoX,posicaoY;
	protected JPanel painelInternoFrame;
	

	//construtor vazio basico
	public FrameInterno(){
		setLocation(10, 10);
        setSize(300,500); 
        setVisible(true);		    
	}


	public FrameInterno(int largura, int altura,String titulo){
 		super(titulo,
          true, //resizable
          true, //closable
          false, //maximizable
          true);//iconifiable

		setLocation(posicaoX, posicaoY);
        setSize(largura,altura); 
        setVisible(true);	

	    mudaPosicao();
	}

	protected abstract void pegaValoresDigitados();

	public void mudaPosicao(){
		posicaoY+=20;
        posicaoY+=20;
      
	}



}