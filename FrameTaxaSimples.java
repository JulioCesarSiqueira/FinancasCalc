import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameTaxaSimples extends FrameInterno {
	private JLabel lbTaxa,lbTipoTaxa,lbResultado;
	private JTextField txfTaxa;

	private String[] opcoes;
	private JComboBox <String >comboTipoTaxa;
	private JTextArea txaResultado;

	private JButton btnConverter;

	private JPanel painelBotoes,painelTextArea;

	double taxa;
	String tipoTaxa;

	double [] resultadoConversao;

	public FrameTaxaSimples(int largura,int altura){
		super(largura,altura,"Taxa Simples");
		
		
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
	public void FrameTaxaSimples (){
		//construtor vazio
	}



	protected void pegaValoresDigitados(){
		this.taxa = Double.parseDouble(txfTaxa.getText());	
		this.tipoTaxa=comboTipoTaxa.getSelectedItem().toString();
	}

	/*
	Os seguintes metodos funcionam da seguinte maneira:

	 	converteTaxas() recebe a taxa a converter e o tipo de
	 	taxa que foi escolhido no comboBox pelo usuario.
		
		a arrray resultadoConversao[] contem 5 posições,
		cada posição representando um tipo de taxa.
		A taxa digitada pelo usuario é guardada nessa array, 
		na posição adequada.

		Em seguida as outras posições da array são completadas
		pelos metodos 
			completaPosicoesAnteriores()
			completaPosicoesPoateriores()

		Por fim os metodos preparaStringImprimir() e mudaTextoArea()
		imprimem o resultado para o usuario

	*/


	private void converteTaxas(double taxa,String tipoTaxa ){
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


	private void completaPosicoesAnteriores(int pos, double d[]){

		for(int i=pos;i>=0;i--){

			if(i==0){ //diario
				return;
			}
			if(i==1){ 
				d[i-1]=d[i]/30; //mensal para diario
			}
			if(i==2){
				d[i-1]=d[i]/3; 	//trimestral para mensal
			}

			if(i==3){ 
				d[i-1]=d[i]/2; //semestral para trimestral
			}
			if(i==4){ 
				d[i-1]=d[i]/2; //anual para semestral
			}

		}




	}

	private void completaPosicoesPosteriores(int pos, double d[]){


		for(int i=pos;i<d.length;i++){

			if(i==0){ 
				d[i+1]=d[i]*30; // diario para mensal
			}
			if(i==1){ 
				d[i+1]=d[i]*3; // mensal para trimestral
			}
			if(i==2){
				d[i+1]=d[i]*2; 	//trimestral para semestral
			}

			if(i==3){ 
				d[i+1]=d[i]*2; //semestral para anual
			}
			if(i==4){ 
				return; 
			}

		}


	}

	public void preparaStringImprimir(double d[]){
		String s = "Taxas Equivalentes a: "+taxa+"\n\n";					
		String[] opcoes = {"Diario","Mensal","Trimestral","Semestral","Anual"};

		for(int i=0;i<d.length;i++){
			s +=d[i]+" "+opcoes[i];			
			s+="\n\n";
		}

		mudaTextoArea(s);
	}
	

	private void mudaTextoArea(String s){
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