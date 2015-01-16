import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class FrameTaxa extends FrameInterno{
	protected JLabel lbTaxa,lbTipoTaxa,lbResultado;
	protected JTextField txfTaxa;

	protected String[] opcoes;
	protected JComboBox <String >comboTipoTaxa;
	protected JTextArea txaResultado;

	protected JButton btnConverter;

	protected JPanel painelBotoes,painelTextArea;

	protected double taxa;
	protected String tipoTaxa;
	protected double [] resultadoConversao;


	public FrameTaxa(){
		//construtor vazio
	}
	public FrameTaxa(int largura,int altura, String titulo){
		super(largura,altura,titulo);

		painelInternoFrame = new JPanel();
		painelInternoFrame.setLayout(new BoxLayout(painelInternoFrame, BoxLayout.PAGE_AXIS));

		painelBotoes = new JPanel();

		painelTextArea = new JPanel();

		//taxa
		lbTaxa = new JLabel("Taxa");
		txfTaxa= new JTextField(10);

		//tipo de taxa
		lbTipoTaxa= new JLabel("Tipo de taxa");

		opcoes= new String[5];
		opcoes[0]="Diario";
		opcoes[1]="Mensal";
		opcoes[2]="Trimestral";
		opcoes[3]="Semestral";
		opcoes[4]="Anual";

		comboTipoTaxa = new JComboBox<>(opcoes);
		
		//resultado
		lbResultado=new JLabel("Resultado");
		txaResultado=new JTextArea(30,50);
		txaResultado.setText("Resultado...");
		txaResultado.setEditable(false);

		//btn converter
		btnConverter =new JButton("converter");
		btnConverter.addActionListener(new BotaoListener());


		painelBotoes.add(lbTaxa);
		painelBotoes.add(txfTaxa);

		painelBotoes.add(lbTipoTaxa);
		painelBotoes.add(comboTipoTaxa);

		painelBotoes.add(btnConverter);

		painelTextArea.add(lbResultado);
		painelTextArea.add(txaResultado);

		painelInternoFrame.add(painelBotoes);
		painelInternoFrame.add(painelTextArea);

	
		
		//adiciona painelInternoFrame ao FrameInterno
		this.add(painelInternoFrame);

	}

	
	protected void pegaValoresDigitados(){
		this.taxa = Double.parseDouble(txfTaxa.getText());	
		this.tipoTaxa=comboTipoTaxa.getSelectedItem().toString();
	}

	protected void converteTaxas(double taxa,String tipoTaxa ){
		char c=tipoTaxa.charAt(0);
		//array que guarda os resultados da conversao
		resultadoConversao = new double[5];
		int posicaoAtual; 
	
		switch(c){
			case 'D'://Diario D / resultadoConversao[0]
				System.out.println("Diario");
				resultadoConversao[0]=taxa;

				break;

			case 'M':   //Mensal M / resultadoConversao[1]
				System.out.println("Mensal");
				resultadoConversao[1]=taxa;
				break;


			case 'T':	//Trimestral t / resultadoConversao[2]
				System.out.println("Trimestral");
				resultadoConversao[2]=taxa;
				break;

			case 'S': //Semestral s / resultadoConversao[3]
				System.out.println("Semestral");
				resultadoConversao[3]=taxa;
				break;	


			case 'A': 		//Anual a / resultadoConversao[4]
				System.out.println("Anual");
				resultadoConversao[4]=taxa;
				break;	

			default:
				System.out.println("Opcao invalida");

		}

		posicaoAtual = retornaPosicaoAtual(resultadoConversao);
		
		if(posicaoAtual!=-1){
			completaPosicoesAnteriores(posicaoAtual,resultadoConversao);
		}	

		if(posicaoAtual!=-1){
			completaPosicoesPosteriores(posicaoAtual,resultadoConversao);
		}

		preparaStringImprimir(resultadoConversao);
	}


	private int retornaPosicaoAtual(double d[]){
	
		for(int i=0;i<d.length;i++){
			if(d[i]!=0.0){
				System.out.println("numero na posicao "+i);
				return i;

			}
		}
		return -1;
		
	}

	abstract protected void completaPosicoesAnteriores(int pos, double d[]);
	abstract protected void completaPosicoesPosteriores(int pos, double d[]);


	public void preparaStringImprimir(double d[]){
		String s = "Taxas Equivalentes a: "+taxa+"\n\n";					
		String[] opcoes = {"Diario","Mensal","Trimestral","Semestral","Anual"};

		for(int i=0;i<d.length;i++){
			s +=d[i]+" "+opcoes[i];			
			s+="\n\n";
		}

		mudaTextoArea(s);
	}

	protected void mudaTextoArea(String s){
		txaResultado.setText(s);
	}


	//classe interna para manipular ações do JButton
	public class BotaoListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			pegaValoresDigitados();
			converteTaxas(taxa,tipoTaxa);			
		}
	}
}