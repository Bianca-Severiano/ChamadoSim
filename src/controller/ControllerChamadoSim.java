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

	public static void IncluirnaFila(Fila fila, Fila filaPrioritarios, int r, int n) {
		Cliente cliente = new Cliente();
		if (r == 1) {
			cliente.nome = JOptionPane.showInputDialog("Nome:");
			cliente.numero = n + 1;
			fila.insert(cliente);

		} else if (r == 2) {
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

		}
	}

	public static void ChamarCliente(Fila fila, Fila filaPrioritarios, int r, int n) throws Exception {
		Cliente cliente;
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
