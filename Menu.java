import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
	protected JMenuBar menuBar;
	protected JMenu menuInicio,menuAjuda, sMenuJuros,sMenuJurosSimples,sMenuJurosComposto;

	protected JMenuItem itemMontanteSimples, itemTaxaSimples, itemJurosSimples,
			  itemMontanteComposto, itemTaxaComposto,itemJurosComposto,
			  itemSobre;

	public Menu(){

					
		//subMenuJuros		
		sMenuJuros = new JMenu("Juros");
		
		
		//submenu JurosSimples e itens
		sMenuJurosSimples= new JMenu("Juros Simples");
		
		itemMontanteSimples= new JMenuItem("Montante Juros Simples");
		itemTaxaSimples = new JMenuItem("Converter Entre Taxas");
		itemJurosSimples = new JMenuItem("Calcular Juros Simples");
		
		sMenuJurosSimples.add(itemMontanteSimples);
		sMenuJurosSimples.add(itemTaxaSimples);
		sMenuJurosSimples.add(itemJurosSimples);

		sMenuJuros.add(sMenuJurosSimples);


		//submenu juros composto e itens
		sMenuJurosComposto= new JMenu("Juros Composto");

		itemMontanteComposto = new JMenuItem("Montante Juros Composto");
		itemTaxaComposto = new JMenuItem("Converter Entre Taxas");
		itemJurosComposto = new JMenuItem("Calcular Juros Composto");

		sMenuJurosComposto.add(itemMontanteComposto);
		sMenuJurosComposto.add(itemTaxaComposto);
		sMenuJurosComposto.add(itemJurosComposto);
		
		sMenuJuros.add(sMenuJurosComposto);
			
	
		//menuInicio
		
		menuInicio = new JMenu("Inicio");
		menuInicio.add(sMenuJuros);
		


		//menu Sobre e subitens
		menuAjuda = new JMenu("Ajuda");
		itemSobre = new JMenuItem("Sobre");
		menuAjuda.add(itemSobre);

		//MenuBar
		menuBar = new JMenuBar();
		menuBar.add(menuInicio);
		menuBar.add(menuAjuda);

		
		adicionaHandlers();	
	}


	public JMenuBar getMenuBar(){
		return menuBar;
	}




    public static enum MenuItens{
    	
    	//menu inicio->juros simples
		MontanteSimples(1),
		TaxaSimples(2),
		JurosSimples(3),
		
		MontanteComposto(4),
		TaxaComposto(5),
		JurosComposto(6),

		Sobre(7);

		private int codigo;

		MenuItens(int cod){
			this.codigo = cod;
		}

		public int getCodigo(){
			return this.codigo;
		}
	}


	//ação dos botões do menu
	public void adicionaHandlers(){
		itemMontanteSimples.addActionListener(new MenuListener());
		itemTaxaSimples.addActionListener(new MenuListener());
		itemJurosSimples.addActionListener(new MenuListener());

		itemMontanteComposto.addActionListener(new MenuListener());
		itemTaxaComposto.addActionListener(new MenuListener());
		itemJurosComposto.addActionListener(new MenuListener());
		
		itemSobre.addActionListener(new MenuListener());

		
	}


	//classe interna
	class MenuListener implements ActionListener{

		public void actionPerformed(ActionEvent ae){							
			
			//menu inicio->juros simples
			if(ae.getSource()==itemMontanteSimples){
				Tela.adicionaFrameInterno(Menu.MenuItens.MontanteSimples);				
			}						

			if(ae.getSource()==itemTaxaSimples){
				Tela.adicionaFrameInterno(Menu.MenuItens.TaxaSimples);				
			}

			if(ae.getSource()==itemJurosSimples){
				Tela.adicionaFrameInterno(Menu.MenuItens.JurosSimples);				
			}	


			//menu inicio->juros composto
			if(ae.getSource()==itemMontanteComposto){
				Tela.adicionaFrameInterno(Menu.MenuItens.MontanteComposto);				
			}	

			if(ae.getSource()==itemTaxaComposto){
				Tela.adicionaFrameInterno(Menu.MenuItens.TaxaComposto);				
			}	

			if(ae.getSource()==itemJurosComposto){
				Tela.adicionaFrameInterno(Menu.MenuItens.JurosComposto);				
			}	

			if(ae.getSource()==itemSobre){
				Tela.adicionaFrameInterno(Menu.MenuItens.Sobre);				
			}	



		}
	}


}