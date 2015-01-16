import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class FrameJuros extends FrameInterno{
	protected JLabel lbCapital,lbTaxa,lbTempo,lbJuros;	
	protected JTextField txfCapital,txfTaxa,txfTempo,txfJuros;

	protected JButton btnCalcular;

	protected  double capital,juros,taxa;
	protected  int tempo;


	public FrameJuros(){
		//construtor vazio
	}

	public FrameJuros(int largura,int altura,String titulo){
		super(largura,altura,titulo);

		painelInternoFrame=new JPanel();

		lbCapital = new JLabel("Capital (R$)");
		lbTaxa  = new JLabel("Taxa (%)");
		lbTempo = new JLabel("Tempo");
		lbJuros= new JLabel("Juros (R$)");

		txfCapital = new JTextField(10);
		txfTaxa = new JTextField(10);
		txfTempo = new JTextField(10);
		txfTaxa = new JTextField(10);

		txfJuros = new JTextField(10);
		txfJuros.setEditable(false);

		btnCalcular= new JButton("Calcular");
		btnCalcular.addActionListener(new BotaoListener());

		painelInternoFrame.add(lbCapital);
		painelInternoFrame.add(txfCapital);

		painelInternoFrame.add(lbTaxa);
		painelInternoFrame.add(txfTaxa);

		painelInternoFrame.add(lbTempo);
		painelInternoFrame.add(txfTempo);

		painelInternoFrame.add(lbJuros);
		painelInternoFrame.add(txfJuros);

		painelInternoFrame.add(btnCalcular);

		//adiciona painelInternoFrame ao FrameInterno
		this.add(painelInternoFrame);


	}

	protected void pegaValoresDigitados(){
		this.capital= Double.parseDouble(txfCapital.getText());
		this.taxa= Double.parseDouble(txfTaxa.getText());
		this.tempo= Integer.parseInt(txfTempo.getText());

	}


	protected abstract double calculaJuros(double capital,double taxa,int tempo);

	//classe interna para manipular ações 
	public class BotaoListener implements ActionListener{


		public void actionPerformed(ActionEvent ae){
			pegaValoresDigitados();

			juros=calculaJuros(capital,taxa,tempo);

			txfJuros.setText(""+juros);
			
		}
	}



}