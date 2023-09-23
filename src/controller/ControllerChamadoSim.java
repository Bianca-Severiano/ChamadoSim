package controller;

import javax.swing.JOptionPane;
import model.Cliente;
import model.Fila;

public class ControllerChamadoSim {

	static int cont;

	public void direcionador(Fila fila, Fila filaPrioritarios, int r, int n) throws Exception {
		if (r == 1 || r == 2) {
			IncluirnaFila(fila, filaPrioritarios, r, n);
		}

		switch (r) {
		case 3: {
			ChamarClienteP(fila, filaPrioritarios, r, n);
			break;
		}
		case 9: {
			System.exit(0);
			break;
		}

		}
	}

	public void IncluirnaFila(Fila fila, Fila filaPrioritarios, int r, int n) {
		
		if (r == 1) {
			System.out.print(fila.size());
			Cliente cliente = new Cliente();
			cliente.nome = JOptionPane.showInputDialog("Nome:");
			cliente.numero = n + 1;
			fila.insert(cliente);
			System.out.println(fila.size());

		} else if (r == 2) {
			Cliente cliente = new Cliente();
			cliente.nome = JOptionPane.showInputDialog("Nome:");
			cliente.numero = n + 1;
			filaPrioritarios.insert(cliente);

		}

	}

	public static void ChamarClienteP(Fila fila, Fila filaPrioritarios, int r, int n) throws Exception {
		Cliente cliente;
		if (cont < 3) {
			if (filaPrioritarios.size() == 0) {
				ChamarCliente(fila, filaPrioritarios, r, n);

			} else {
				try {
					cliente = (Cliente) filaPrioritarios.remove();
					JOptionPane.showMessageDialog(null, "Cliente: " + cliente.nome + " \n Senha: " + cliente.numero);
				} catch (Exception e) {
					System.err.println("Fila P vazia");
				} finally {
					cont++;
				}
			}

		} else{
			ChamarCliente(fila, filaPrioritarios, r, n);
			cont = 0;
		}
	}

	public static void ChamarCliente(Fila fila, Fila filaPrioritarios, int r, int n) throws Exception {
		Cliente cliente;
		System.out.println(fila.size());
		try {
			cliente = (Cliente) fila.remove();
			JOptionPane.showMessageDialog(null, "Cliente: " + cliente.nome + " \n Senha: " + cliente.numero);
		} catch (Exception b) {
			System.err.println("Fila Vazia");
			
		} finally {
			cont = 0;
		}
	}

}
