package view;

import javax.swing.JOptionPane;


import controller.ControllerChamadoSim;
import model.Cliente;
import model.Fila;


public class Principal {

	public static void main(String[] args) throws Exception {
		
		Fila<Cliente> fila = new Fila<>();
		Fila<Cliente> filaPrioritarios = new Fila<>();
		ControllerChamadoSim c = new ControllerChamadoSim();
		
		int r=0;
		int n=0;
		do{
			r = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir nova senha \n2- Inserir nova senha prioritária \n3-Chamar atendimento\n9-Sair"));
			c.direcionador(fila, filaPrioritarios, r, n);
			n++;
			
		}while(r!=9);
	}
	
}
