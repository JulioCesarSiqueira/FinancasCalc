import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameMontanteSimples extends FrameInterno{
	JLabel lbCapital, lbTaxa,lbTempo,lbTotalMontante;
	JTextField txfCapital, txfTaxa,txfTempo, txfTotalMontante;
	
	JButton btnCalcular;
	
	private double montanteTotal, capital, taxa;
	private int tempo;

	//formula 
	//montante = capital*(1+taxa.tempo)


	public FrameMontanteSimples(){


	}

	public FrameMontanteSimples(int largura,int altura){
		super(largura,altura,"Montante Simples");

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


	private double calculaMontanteSimples(double capital,double taxa,int tempo){
		double total;

		total = capital*(1+(taxa*tempo));

		return total;
	}

	//protected abstract void pegaValoresDigitados();
	protected void pegaValoresDigitados(){
		this.capital = Double.parseDouble(txfCapital.getText());
		this.taxa = Double.parseDouble(txfTaxa.getText());
		this.tempo = Integer.parseInt(txfTempo.getText());		
	}

	//classe interna
	public class BotaoListener implements ActionListener{


		public void actionPerformed(ActionEvent ae){
			pegaValoresDigitados();

			montanteTotal=calculaMontanteSimples(capital,taxa,tempo);

			txfTotalMontante.setText(""+montanteTotal);
			
		}
	}


}