package br.univille.poo.app;

import java.util.Scanner;
import br.univille.poo.app.entidade.Lista;
import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.servico.ConcluirTarefa;
import br.univille.poo.app.servico.CriarLista;
import br.univille.poo.app.servico.CriarTarefa;
import br.univille.poo.app.servico.ListarListas;
import br.univille.poo.app.servico.ListarTarefas;
import br.univille.poo.app.servico.PriorizarTarefa;
import br.univille.poo.app.servico.VincularTarefa;

public class Main {
  public static void main(String[] args) {
    CriarTabelas.criarTabelas();
    Integer resource = 2;

    while (resource != 0) {
      System.out.println("\b");
      System.out.println("==========================================================================\b");
      System.out.println("                       Lista de Comandos Possíveis                        \b");
      System.out.println(" 1 - Adiconar Tarefa \b");
      System.out.println(" 2 - Listar Tarefas \b");
      System.out.println(" 3 - Concluir Tarefas \b");
      System.out.println(" 4 - Priorizar Tarefas \b");
      System.out.println(" 5 - Adicionar Lista \b");
      System.out.println(" 6 - Adicionar Tarefas à uma Lista \b");
      System.out.println(" 0 - Finalizar \b");
      System.out.println("==========================================================================\b");
      System.out.println("\b");

      System.out.print("Digite o número correspondente a operação desejada: ");
      System.out.println("\b");
      Scanner teclado = new Scanner(System.in);
      resource = teclado.nextInt();

      if (resource == 1) {
        System.out.print("Digite a descrição da tarefa que desja criar: ");
        System.out.println("\b");
        Scanner teclado2 = new Scanner(System.in);
        String descricao = teclado2.nextLine();
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);
        CriarTarefa criarTarefa = new CriarTarefa();

        try {
          criarTarefa.criar(tarefa);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("A Tarefa foi criada com sucesso!\b");

      } else if (resource == 2) {
        ListarTarefas listarTarefas = new ListarTarefas();
        for (Tarefa t : listarTarefas.obterTodos()) {
          System.out.println(t);
        }

      } else if (resource == 3) {

        System.out.println("Digite a tarefa que deseja concluir (digite o ID da tarefa)");
        System.out.println("\b");
        ListarTarefas listarTarefas = new ListarTarefas();
        for (Tarefa t : listarTarefas.obterTodos()) {
          System.out.println(t);
        }
        Scanner teclado2 = new Scanner(System.in);
        Integer escolha = teclado2.nextInt();
        ConcluirTarefa concluirTarefa = new ConcluirTarefa();

        try {
          concluirTarefa.concluir(escolha);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("A Tarefa foi concluida com sucesso!\b");
        System.out.println("\b");

      } else if (resource == 4) {

        System.out.println("Digite a tarefa que deseja priorizar (digite o ID da tarefa)\b");
        System.out.println("\b");
        ListarTarefas listarTarefas = new ListarTarefas();
        for (Tarefa t : listarTarefas.obterTodos()) {
          System.out.println(t);
        }
        Scanner teclado2 = new Scanner(System.in);
        Integer escolha = teclado2.nextInt();
        System.out.println("======================================");
        System.out.println("     Digite o nível de prioridade     ");
        System.out.println(" Baixo");
        System.out.println(" Mediano");
        System.out.println(" Alto");
        System.out.println("======================================");
        System.out.println("\b");
        Scanner teclado3 = new Scanner(System.in);
        String nvlPriori = teclado3.nextLine();

        PriorizarTarefa priorizarTarefa = new PriorizarTarefa();
        try {
          priorizarTarefa.priorizar(escolha, nvlPriori);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("A Tarefa foi priorizada com sucesso!\b");

      } else if (resource == 5) {

        System.out.print("Qual seria o nome da lista que deseja criar? ");
        System.out.println("\b");
        Scanner teclado2 = new Scanner(System.in);
        String listaName = teclado2.nextLine();

        Lista lista = new Lista();
        lista.setLista_name(listaName);

        CriarLista criarLista = new CriarLista();
        try {
          criarLista.criar(listaName);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println(" Lista Criada com sucesso !!! \b");

      } else if (resource == 6) {

        System.out.println("Qual seria a tarefa que deseja Adicionar a lista? (escolha pelo ID da tarefa) \b");
        ListarTarefas listarTarefas = new ListarTarefas();
        for (Tarefa t : listarTarefas.obterTodos()) {
          System.out.println(t);
        }
        Scanner teclado2 = new Scanner(System.in);
        Integer tarefaId = teclado2.nextInt();

        System.out.println("\n\n Em qual lista deseja adicionar a tarefa? (escolha pelo ID da lista) \b");
        ListarListas listarListas = new ListarListas();
        for (Lista l : listarListas.obterTodos()) {
          System.out.println(l);
        }
        Scanner teclado3 = new Scanner(System.in);
        Integer listaId = teclado3.nextInt();

        VincularTarefa vincularTarefa = new VincularTarefa();
        try {
          vincularTarefa.vincular(tarefaId, listaId);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Tarefa Priorizada com sucesso !!! \b");

      } else if (resource == 0) {
        System.out.println("Finalizando Programa");
      } else {
        System.out.println("Comando Inválido");
        System.out.println("\b");
      }
    }
  }
}