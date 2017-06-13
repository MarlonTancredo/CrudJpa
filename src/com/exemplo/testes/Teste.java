package com.exemplo.testes;

import java.util.List;
import java.util.Scanner;

import com.exemplo.entidade.Cliente;
import com.exemplo.repositorio.RepositorioCliente;

public class Teste {

	private static Scanner scan;

	public static void main(String[] args) {
		

		scan = new Scanner(System.in);

		String nome;
		int idade;
		int id;
		
		boolean verdadeiro = true;
		while (verdadeiro) {

			System.out.println("S para salvar P para procurar R para remover L para listar todos ou F para fechar");
			String escolha = scan.next();
			
			if (escolha.equalsIgnoreCase("S")) {
				
				System.out.println("Digite o nome: ");
				nome = scan.next();

				System.out.println("Digite uma idade: ");
				idade = scan.nextInt();

				RepositorioCliente respositorioCliente = new RepositorioCliente();
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setIdade(idade);
				respositorioCliente.salvar(cliente);

			} else if (escolha.equalsIgnoreCase("P")) {
				
				System.out.println("Digite o número do id: ");
				id = scan.nextInt();

				RepositorioCliente respositorioCliente = new RepositorioCliente();
				Cliente cliente = respositorioCliente.procurar(id);
				
				System.out.println(cliente.getNome());

			} else if (escolha.equalsIgnoreCase("R")) {

				System.out.println("Digite o número do id a ser removido: ");
				id = scan.nextInt();

				RepositorioCliente respositorioCliente = new RepositorioCliente();
				Cliente cliente = respositorioCliente.procurar(id);
				respositorioCliente.remover(cliente);

			} else if (escolha.equalsIgnoreCase("L")) {

				RepositorioCliente respositorioCliente = new RepositorioCliente();
				List<Cliente> clientes = respositorioCliente.listarTodos();

				for (Cliente cliente : clientes) {
					System.out.println("Id: " + cliente.getId() + " -  Nome: " + cliente.getNome() + "  - Idade: " + cliente.getIdade());
				}
			} else if (escolha.equalsIgnoreCase("f")) {

				System.out.println("Você saiu do programa");

				verdadeiro = false;

				break;

			} else {

				System.out.println("Você não digitou a letra correta apenas S, P, R, L ou F.");
			}
		}
	}
}
