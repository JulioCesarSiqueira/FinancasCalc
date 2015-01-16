import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameTaxaComposto extends FrameTaxa{
	

	public FrameTaxaComposto(int largura,int altura){
		super(largura,altura,"Taxa Composto");
		
		
	}
	public void FrameTaxaSimples (){
		//construtor vazio
	}
	
	protected void completaPosicoesAnteriores(int pos, double d[]){
		double atual=0,ant=0,raiz=0,base=0;

		for(int i=pos;i>=0;i--){

			if(i==0){ //diario
				return;
			}
			if(i==1){ 
				//mensal para diario 
				atual = d[i];
				ant= Math.pow(atual+1,(1.0/30))-1;				
				d[i-1]=ant;				
			}
			if(i==2){
				//trimestral para mensal
				atual = d[i];
				ant= Math.pow(atual+1,(1.0/3))-1;				
				d[i-1]=ant;
			}

			if(i==3){ 
				//semestral para trimestral
				atual = d[i];
				ant= Math.pow(atual+1,(1.0/2))-1;				
				d[i-1]=ant;
			}
			if(i==4){ 
				//anual para semestral
				atual = d[i];
				ant= Math.pow(atual+1,(1.0/2))-1;				
				d[i-1]=ant;

			}
			atual=0;
			ant=0;


		}




	}

	protected void completaPosicoesPosteriores(int pos, double d[]){
		double atual=0,prox=0;

		for(int i=pos;i<d.length;i++){

			if(i==0){ 
				// diario para mensal			
				atual=d[i];
				prox= (Math.pow((1.0+atual),30)-1.0);
				d[i+1]=prox;
			}
			if(i==1){ 
				// mensal para trimestral
				atual=d[i];
				prox= (Math.pow((1.0+atual),3)-1.0);
				d[i+1]=prox;
			}
			if(i==2){
				//trimestral para semestral 
				atual=d[i];
				prox= (Math.pow((1.0+atual),2)-1.0);
				d[i+1]=prox;				
			}

			if(i==3){ 
				//semestral para anual 	
				atual=d[i];
				prox= (Math.pow((1.0+atual),2)-1.0);
				d[i+1]=prox;	
			}
			if(i==4){ 
				return; 
			}

			atual =0;
			prox=0;

		}


	}
}