/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedicopoo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author r
 */
public class CentroMedico extends CentroMedicoPOO {

    private static List<Utente> utentes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();

    public static void menuPrincipal() {

        boolean sair = true;

        do {

            System.out.println("1 - Registar um novo utente\n" // adicionarUtente
                    + "2 - Registar um novo médico\n" // adicionarMedico
                    + "3 - Realizar uma nova consulta de diagnóstico\n" // ?
                    + "4 - Realizar uma nova consulta de resultados\n" // ?
                    + "5 - Listar utentes\n" // menuListarUtentes
                    + "6 - Listar médicos\n" // menuListarMedicos
                    + "7 - Valor total que o centro médico já recebeu dos utentes\n" // ?
                    + "8 - Número de consultas que o centro médico já realizou\n" // ?
                    + "9 - Sair do programa\n"); // ?

            Scanner entradaDados = new Scanner(System.in, "Cp1252");
            int op;

            System.out.print("Escolha uma opção: ");
            op = entradaDados.nextInt();

            switch(op) {
                case 1:
                    adicionarUtente();
                    break;
                case 2:
                    adicionarMedico();
                    break;
                case 3:
                    adicionarConsulta();
                    break;
                case 4:
                    //
                    break;
                case 5:
                    menuListarUtentes();
                    break;
                case 6:
                    menuListarMedicos();
                    break;
                case 7:
                    //
                    break;
                case 8:
                    // numeroConsultasFeitas();
                    break;
                case 9:
                    sair = false;
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

    }

    public static void adicionarUtente() {

        String nome;
        int idade;
        String temSeguro;
        int numeroUtente;

        boolean seguroInvalido = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        Random geradorAleatorio = new Random();
        
        Utente utenteTeste = new Utente();
        
        System.out.print("Nome: " + "\n");
        nome = entradaDados.nextLine();
        
        System.out.print("Idade: " + "\n");
        idade = entradaDados.nextInt();

        numeroUtente = geradorAleatorio.nextInt(100000);

        System.out.print("O utente tem seguro? S/N: " + "\n");

        temSeguro = entradaDados.nextLine(); // arranja isto? não sei porquê é que tenho que ter 2
        temSeguro = entradaDados.nextLine();

        if (temSeguro.equals("S")) {
            utenteTeste.setTemSeguro(true);
            utenteTeste.setDescontoAcumulado(0.40); // EDITAR ISTO
            System.out.print("CONFIRMO QUE O UTENTE TEM SEGURO"); // APENAS PARA TESTES
            // ATRIBUI DESCONTO
        }
        else if (temSeguro.equals("N")) {
            utenteTeste.setTemSeguro(false);
        }
        else {
            System.out.println("Valor inválido. Inserção de dados interrompida. Voltamos ao menu principal.");
            // menuPrincipal();
            seguroInvalido = true;
        }

        /////////////////////////////////////////////

        if(!seguroInvalido) {
            utenteTeste.setNome(nome);
            utenteTeste.setIdade(idade);
            utenteTeste.setNumeroUtente(numeroUtente);

            utentes.add(utenteTeste); // Utente adicionado à lista de utentes

            /// TESTES ///
            // System.out.print(utenteTeste.getNome());
            // System.out.print(utenteTeste.getIdade());
        }
        
    }

    public static void adicionarMedico() {

        String nome;
        int idade;
        int numeroMedico;
        String especialidade;

        boolean registaMedico = false;
        boolean especialidadeInvalida = true;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");
        Random geradorAleatorio = new Random();

        Medico medicoTeste = new Medico();

        System.out.println("Nome: " + "\n");
        nome = entradaDados.nextLine();

        System.out.println("Idade: " + "\n");
        idade = entradaDados.nextInt();

        // O número único do médico começa em 100000
        numeroMedico = geradorAleatorio.nextInt(100000) + 100000;

        System.out.println("Especialidade: " + "\n");

        especialidade = entradaDados.nextLine(); // arranja isto? não sei porquê é que tenho que ter 2
        especialidade = entradaDados.nextLine();

        for(int i = 0; i < Medico.especialidades.length; i++) {
            if(especialidade.equals(Medico.especialidades[i])) {
                // medicoTeste.setEspecialidade(especialidade);
                registaMedico = true;
                especialidadeInvalida = false;
            }

        }

        if(especialidadeInvalida){
            System.out.println("ESPECIALIDADE INVALIDA. Inserção de dados interrompida."); // APENAS TESTES
            // registaMedico = false;
            // menuPrincipal();
        }

        if(registaMedico) {
            medicoTeste.setNome(nome);
            medicoTeste.setIdade(idade);
            medicoTeste.setNumeroMedico(numeroMedico);
            medicoTeste.setEspecialidade(especialidade);

            medicos.add(medicoTeste); // Médico adicionado à lista de médicos
        }

        /// TESTES ///
        // System.out.print(medicoTeste.getNome());
        // System.out.print(medicoTeste.getIdade());

    }

    public static void adicionarConsulta() {

        int numeroUtente;
        int numeroMedico;
        String data;
        // boolean flagDiagnostico;
        // boolean flagResultados;

        boolean numeroUtenteCorrecto = false;
        boolean numeroMedicoCorrecto = false;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        Consulta consultaTeste = new Consulta();

        System.out.println("Insira o número de um utente: " + "\n");
        numeroUtente = entradaDados.nextInt();

        // List<Utente> resultado = utentes.stream()
                // .filter(item -> item.getNumeroUtente() == numeroUtente)
                // .collect(Collectors.toList());

        for(int i = 0; i < utentes.size(); i++) {

            if (utentes.get(i).getNumeroUtente() == numeroUtente) {
                numeroUtenteCorrecto = true;
                System.out.println("NÚMERO ESTÁ CORRETO");
            }
            else {
                numeroUtenteCorrecto = false;
                System.out.println("NÚMERO ESTÁ INCORRETO");
            }

        }

        System.out.println("Insira o número de um médico " + "\n");
        numeroMedico = entradaDados.nextInt();

        for(int i = 0; i < medicos.size(); i++) {

            if (medicos.get(i).getNumeroMedico() == numeroMedico) {
                numeroMedicoCorrecto = true;
                System.out.println("NÚMERO ESTÁ CORRETO");
            }
            else {
                numeroMedicoCorrecto = false;
                System.out.println("NÚMERO ESTÁ INCORRETO");
            }

        }

        System.out.println("Insira a data (Ano): " + "\n");
        data = entradaDados.next();

        int a = Integer.parseInt(data);

        System.out.println("Insira a data (Mês): " + "\n");
        data = entradaDados.next();

        int m = Integer.parseInt(data);

        System.out.println("Insira a data (Dia): " + "\n");
        data = entradaDados.next();

        int d = Integer.parseInt(data);

        // ATRIBUIÇÃO DE DATA (EXEMPLO)
        // LocalDate testeData = LocalDate.of(a,m,d);


        // Aqui assumimos logo que a consulta é de diagnóstico, obviamente


        // if(registaConsulta) { // não sei, talvez tenha que usar Interface...

            // consultaTeste

        // }


    }

    public static void menuListarUtentes() {

        boolean sair = true;

        do {
            System.out.println("----- MENU DE LISTAGEM DE UTENTES -----\n"
                    +"1 - Listar todos os utentes (nome, idade e número de utente)\n"
                    +"2 - Listar os utentes que um médico consultará num dado dia\n"
                    +"3 - Listar o valor total pago por cada utente\n"
                    +"4 - Voltar atrás\n");

            Scanner entradaDados = new Scanner(System.in, "Cp1252");
            int op;

            System.out.print("Escolha uma opção: ");
            op = entradaDados.nextInt();

            switch(op) {
                case 1:
                    listarInfoUtentes();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    // listarPagamentosUtentes();
                    break;
                case 4:
                    sair = false;
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

    }

    public static void listarInfoUtentes() {

        for(int i = 0; i < utentes.size(); i++) {

            System.out.println("NÚMERO DE UTENTE: " + utentes.get(i).getNumeroUtente());
            System.out.println("Nome: " + utentes.get(i).getNome());
            System.out.println("Idade: " + utentes.get(i).getIdade());

            if (utentes.get(i).getTemSeguro())
                System.out.println("O utente tem seguro.");
            else
                System.out.println("O utente não tem seguro.");

            System.out.println("////////////////////////////////////");

        }

    }

    // public static void listarPagamentosUtentes() { }

    // public static int numeroConsultasFeitas() { }

    public static void menuListarMedicos() {

        boolean sair = true;

        do {

            System.out.println("----- MENU DE LISTAGEM DE MÉDICOS -----\n"
                    + "1 - Listar médicos com uma dada especialidade\n"
                    + "2 - Listar todos os médicos (ordenados pela classificação média)\n"
                    + "3 - Voltar atrás\n");

            Scanner entradaDados = new Scanner(System.in, "Cp1252");
            int op;

            System.out.print("Escolha uma opção: ");
            op = entradaDados.nextInt();

            switch(op) {
                case 1:
                    menuEspecialidadeMedicos();
                    break;
                case 2:
                    listarInfoMedicos();
                    break;
                case 3:
                    sair = false;
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

    }

    public static void menuEspecialidadeMedicos() {

        String especialidade;
        boolean encontreiEspecialidade = false;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        System.out.println("Escolha uma especialidade: ");
        especialidade = entradaDados.nextLine();

        // VERIFICA SE A ESPECIALIDADE É VÁLIDA OU NÃO
        // INDEPENDENTEMENTE DE METER UMA ESPECIALIDADE QUE NÃO EXISTE, O PROGRAMA NÃO REBENTA

        for (String especialidadeExistente : Medico.especialidades) {
            if (especialidadeExistente.equals(especialidade)) {
                encontreiEspecialidade = true;
                break;
            }
        }

        if (!encontreiEspecialidade) {
            System.out.println("MÉTODO INTERROMPIDO");
            return;
        }

        List<Medico> listaFiltradaCopiada = medicos.stream()
                .filter(p -> p.getEspecialidade().equals(especialidade))
                .collect(Collectors.toList());

        for(int i = 0; i < listaFiltradaCopiada.size(); i++) {

            System.out.println("NÚMERO DE MÉDICO: " + listaFiltradaCopiada.get(i).getNumeroMedico());
            System.out.println("Nome: " + listaFiltradaCopiada.get(i).getNome());
            System.out.println("Idade: " + listaFiltradaCopiada.get(i).getIdade());
            System.out.println("Especialidade: " + listaFiltradaCopiada.get(i).getEspecialidade());

            System.out.println("////////////////////////////////////");

        }

    }

    // LISTARMEDICOS ESTÁ INCOMPLETO

    public static void listarInfoMedicos() {

        for(int i = 0; i < medicos.size(); i++) {

            System.out.println("NÚMERO DE MÉDICO: " + medicos.get(i).getNumeroMedico());
            System.out.println("Nome: " + medicos.get(i).getNome());
            System.out.println("Idade: " + medicos.get(i).getIdade());
            System.out.println("Especialidade: " + medicos.get(i).getEspecialidade());

            System.out.println("////////////////////////////////////");

        }

    }

    // NUNCA TESTADO, PROVAVELMENTE NÃO FUNCIONA //

    public static void avaliarAlguem(Utente utente, Medico medico) {

        int nota;
        double media;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        ////////////// *** APENAS PARA TESTES *** //////////////

        // insere medico aqui

        ////////////////////////////////////////////////////////



        System.out.println("Avaliação (inteiro): ");
        nota = entradaDados.nextInt();

        medico.setNumAvaliacoes(medico.getNumAvaliacoes() + 1); // incrementa número de avaliações feitas
        medico.setSomaNotas(medico.getSomaNotas() + nota); // soma o total da nota

        media = Avaliacao.calculaMedia(medico.getSomaNotas(), medico.getNumAvaliacoes()); // re-calcula a média

        medico.setAvaliacaoMedia(media);

    }
    
}
