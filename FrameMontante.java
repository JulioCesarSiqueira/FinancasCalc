import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat; 

public abstract class FrameMontante extends FrameInterno{
	protected JLabel lbCapital, lbTaxa,lbTempo,lbTotalMontante;
	protected JTextField txfCapital, txfTaxa,txfTempo, txfTotalMontante;
	
	protected JButton btnCalcular;

	protected double montanteTotal, capital, taxa;
	protected int tempo;


	public FrameMontante(){
		//construtor vazio
	}

	public FrameMontante(int largura,int altura,String titulo){
		super(largura,altura,titulo);

		painelInternoFrame = new JPanel();


		lbCapital = new JLabel("Capital (R$)");
		lbTaxa  = new JLabel("Taxa (%)");
		lbTempo = new JLabel("Tempo");
		lbTotalMontante = new JLabel("Total Montante (R$)");

		txfCapital = new JTextField(10);
		txfTaxa = new JTextField(10);
		txfTempo = new JTextField(10);
		txfTaxa = new JTextField(10);
		txfTotalMontante = new JTextField(10);
		txfTotalMontante.setEditable(false);

		btnCalcular= new JButton("Calcular");
		btnCalcular.addActionListener(new BotaoListener());


		painelInternoFrame.add(lbCapital);
		painelInternoFrame.add(txfCapital);

		painelInternoFrame.add(lbTaxa);
		painelInternoFrame.add(txfTaxa);

		painelInternoFrame.add(lbTempo);
		painelInternoFrame.add(txfTempo);

		
		painelInternoFrame.add(lbTotalMontante);
		painelInternoFrame.add(txfTotalMontante);

		painelInternoFrame.add(btnCalcular);

		//adiciona painelInternoFrame ao FrameInterno
		this.add(painelInternoFrame);
	}


	//protected abstract void pegaValoresDigitados();
	protected void pegaValoresDigitados(){
		this.capital = Double.parseDouble(txfCapital.getText());
		this.taxa = Double.parseDouble(txfTaxa.getText());
		this.tempo = Integer.parseInt(txfTempo.getText());		
	}


	abstract protected double calculaMontante(double capital,double taxa,int tempo);



	//classe interna
	public class BotaoListener implements ActionListener{


		public void actionPerformed(ActionEvent ae){
			pegaValoresDigitados();

			montanteTotal=calculaMontante(capital,taxa,tempo);

			//para formatara a saida com 2 casas decimais
			DecimalFormat df = new DecimalFormat("#.##");  
			txfTotalMontante.setText(df.format(montanteTotal));	

			
		}
	}
}