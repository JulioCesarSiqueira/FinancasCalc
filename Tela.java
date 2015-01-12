import javax.swing.*;
import java.awt.*;




public class Tela extends JFrame {
	private JFrame frame;
	private int larguraFrame; 
	private int alturaFrame; 
	private static JDesktopPane desktopPane;

	private Menu menu; //composição



	public Tela(){
		menu = new Menu();
				
		//estrutura geral da  GUI

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setTitle("Finanças Calculator");

		// Create and Set up the GUI.
		desktopPane = new JDesktopPane();	

		frame.getContentPane().add(BorderLayout.NORTH,menu.getMenuBar());	
		frame.getContentPane().add(BorderLayout.CENTER, desktopPane);
		

		//tamanho base, será dimensionado conforme necessidade
		frame.setSize(800,600); 
		frame.setVisible(true);
		//frame.setResisable(false);


				
	}


	//GETs
	public int getLarguraFrame(){
		return this.larguraFrame;
	}


	public int getAlturaFrame(){
		return this.alturaFrame;
	}



	//SETS

	public void setTamanhoFrame(int largura,int altura){
		frame.setSize(largura,altura);
	}


	public static void adicionaFrameInterno(Menu.MenuItens item){
		FrameInterno frameInterno=null;

		switch(item){
			case MontanteSimples :
				frameInterno = new FrameMontanteSimples(150,500);
				System.out.println("Montante Simples");
				break;

			case TaxaSimples:
				frameInterno = new FrameTaxaSimples(600,300);
				System.out.println("Taxa Simples");
				break;

			case JurosSimples :
				System.out.println("Juros Simples");
				break;



			case MontanteComposto :
				System.out.println("Montante Composto");
				break;


			case TaxaComposto :
				System.out.println("Taxa Composto");
				break;


			case JurosComposto :
				System.out.println("Juros Composto");
				break;								


			case Sobre :
				System.out.println("Sobre");
				break;

			default:
				System.out.println("Item desconhecido");


		}

       	//FrameMontanteSimples frameInterno = new FrameMontanteSimples(150,500);
         
         if(frameInterno!=null){
         	desktopPane.add(frameInterno);
         }
         

    
	
    }//fim de AdicionaFrame()

}