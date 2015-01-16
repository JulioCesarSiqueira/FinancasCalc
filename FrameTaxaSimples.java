import javax.swing.*;
import java.awt.*;


public class FrameTaxaSimples extends FrameTaxa{
	

	public FrameTaxaSimples(int largura,int altura){
		super(largura,altura,"Taxa Simples");
		
		
	}
	public void FrameTaxaSimples (){
		//construtor vazio
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

	

	protected void completaPosicoesAnteriores(int pos, double d[]){

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

	protected void completaPosicoesPosteriores(int pos, double d[]){


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


	

	


}