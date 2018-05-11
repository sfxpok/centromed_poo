package centromedicopoo;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import java.util.Comparator;

public class CentroMedico extends CentroMedicoPOO {

    private static List<Utente> utentes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();

    private static int contadorInstanciasNumeroUtente = 0;
    private static int contadorInstanciasNumeroMedico = 0;

    public static void adicionarUtente() {

        String nome;
        int idade;
        int numeroUtente;
        String temSeguro;

        boolean seguroInvalido = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        
        Utente utente = new Utente();
        
        System.out.print("Nome: " + "\n");
        nome = entradaDados.nextLine();
        
        System.out.print("Idade: " + "\n");
        idade = entradaDados.nextInt();

        contadorInstanciasNumeroUtente++;
        numeroUtente = contadorInstanciasNumeroUtente;

        System.out.print("O utente tem seguro? S/N: " + "\n");

        temSeguro = entradaDados.nextLine(); // arranja isto? não sei porquê é que tenho que ter 2
        temSeguro = entradaDados.nextLine();

        if (temSeguro.equals("S") || temSeguro.equals("s")) {
            utente.setTemSeguro(true);
            // utente.setDescontoAcumulado(0.40); // EDITAR ISTO
            System.out.print("CONFIRMO QUE O UTENTE TEM SEGURO"); // APENAS PARA TESTES
            // ATRIBUI DESCONTO
        }
        else if (temSeguro.equals("N") || temSeguro.equals("n")) {
            utente.setTemSeguro(false);
        }
        else {
            System.out.println("Valor inválido. Inserção de dados interrompida. Voltamos ao menu principal.");
            // menuPrincipal();
            seguroInvalido = true;
        }

        /////////////////////////////////////////////

        if(!seguroInvalido) {
            utente.setNome(nome);
            utente.setIdade(idade);
            utente.setNumeroUtente(numeroUtente);

            utentes.add(utente); // Utente adicionado à lista de utentes

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

        Medico medico = new Medico();

        System.out.println("Nome: " + "\n");
        nome = entradaDados.nextLine();

        System.out.println("Idade: " + "\n");
        idade = entradaDados.nextInt();

        contadorInstanciasNumeroMedico++;
        numeroMedico = contadorInstanciasNumeroMedico;

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
            medico.setNome(nome);
            medico.setIdade(idade);
            medico.setNumeroMedico(numeroMedico);
            medico.setEspecialidade(especialidade);

            medicos.add(medico); // Médico adicionado à lista de médicos
        }

        /// TESTES ///
        // System.out.print(medicoTeste.getNome());
        // System.out.print(medicoTeste.getIdade());

    }

    public static void adicionarConsulta() {

        int numeroUtente;
        int numeroMedico;
        int dia;
        // boolean flagDiagnostico;
        // boolean flagResultados;

        Utente utente = null;
        Medico medico = null;

        boolean numeroUtenteCorrecto = false;
        boolean numeroMedicoCorrecto = false;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        Consulta consultaTeste = new Consulta();

        System.out.println("Insira o número de um utente: " + "\n");
        numeroUtente = entradaDados.nextInt();

        // List<Utente> resultado = utentes.stream()
                // .filter(item -> item.getNumeroUtente() == numeroUtente)
                // .collect(Collectors.toList());

        for (int i = 0; i < utentes.size(); i++) {
            utente = utentes.get(i);
            if (utente.getNumeroUtente() == numeroUtente) {
                System.out.println("NÚMERO ENCONTRADO");
                break;
            }
            else {
                System.out.println("NUMERO NÃO ENCONTRADO");
                // break;
            }

        }

        System.out.println("Insira o número de um médico " + "\n");
        numeroMedico = entradaDados.nextInt();

        for (int i = 0; i < medicos.size(); i++) {
            medico = medicos.get(i);
            if (medico.getNumeroMedico() == numeroMedico) {
                System.out.println("NÚMERO ENCONTRADO");
                break;
            }
            else {
                System.out.println("NUMERO NÃO ENCONTRADO");
                // break;
            }

        }

        // O dia é inserido como inteiro e não existem meses nem anos, é tudo em dias

        System.out.println("Insira o dia: " + "\n");
        dia = entradaDados.nextInt();

        consultaTeste.setNumeroUtente(numeroUtente);
        consultaTeste.setNumeroMedico(numeroMedico);
        consultaTeste.setDia(dia);
        // consultaTeste.setFlagDiagnostico(flagDiagnostico);
        // consultaTeste.setFlagResultados(flagResultados);

    }

    // public static void listarPagamentosUtentes() { }

    // public static int numeroConsultasFeitas() { }

    public static void consultarEspecialidadeMedico() {

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

        listarInfoMedicos(listaFiltradaCopiada);

    }

    public static void avaliarAlguem(Medico medico) {

        double nota;
        double media;
        DecimalFormat mediaArredondada = new DecimalFormat(".##");

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        System.out.println("Avaliação (inteiro): ");
        nota = entradaDados.nextDouble();

        medico.setNumAvaliacoes(medico.getNumAvaliacoes() + 1); // incrementa número de avaliações feitas
        medico.setSomaNotas(medico.getSomaNotas() + nota); // soma o total da nota


        media = Avaliacao.calculaMedia(medico.getSomaNotas(), medico.getNumAvaliacoes()); // re-calcula a média
        System.out.println("A média calculada: " + mediaArredondada.format(media));

        medico.setAvaliacaoMedia(media);

        return;

    }

    public static void consultarClassificacoesOrdenadas() {

        List<Medico> listaOrdenadaClassificacao = new ArrayList<>(medicos);

        listaOrdenadaClassificacao.sort(Comparator.comparingDouble(Medico::getAvaliacaoMedia)
                .reversed());

        listarInfoMedicos(listaOrdenadaClassificacao);

    }

    // public static void avancaUmDia() { }

    /////////////////////////////////////////////////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////        OUTPUT DE MENUS        ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    /////////////////////////////////////////////////////

    public static void menuPrincipal() {

        boolean sair = true;

        Medico medicoAvaliado = new Medico("Ana", 32, 102346,"Urologia"); // APENAS PARA DEBUGGING DA AVALIAÇÃO DO MÉDICO
        Medico medicoAvaliadoDois = new Medico("Bruno", 47, 103469, "Pediatra"); // APENAS PARA DEBUGGING DA AVALIAÇÃO DO MÉDICO

        medicos.add(medicoAvaliado);
        medicos.add(medicoAvaliadoDois);

        Utente utenteConsulta = new Utente("Carlota",46,39123,0,0,0,true,null);
        Utente utenteConsultaDois = new Utente("Carlos",20,39122,0,0,0,false,null);

        utentes.add(utenteConsulta);
        utentes.add(utenteConsultaDois);

        // Os indivíduos acima são só para fins de teste.

        do {

            System.out.println("1 - Registar um novo utente\n" // adicionarUtente
                    + "2 - Registar um novo médico\n" // adicionarMedico
                    + "3 - Realizar uma nova consulta de diagnóstico\n" // ?
                    + "4 - Realizar uma nova consulta de resultados\n" // ?
                    + "5 - Listar utentes\n" // menuListarUtentes
                    + "6 - Listar médicos\n" // menuListarMedicos
                    + "7 - Valor total que o centro médico já recebeu dos utentes\n" // ?
                    + "8 - Número de consultas que o centro médico já realizou\n" // ?
                    + "9 - Sair do programa\n" // ?
                    + "10 - !!! DEBUGGING !!! - Atribuir avaliação a um médico\n"
                    + "11 - Avançar um dia\n");

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
                case 10:
                    avaliarAlguem(medicoAvaliado);
                    avaliarAlguem(medicoAvaliadoDois);
                    break;
                case 11:
                    // avancaUmDia();
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

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
                    consultarEspecialidadeMedico();
                    break;
                case 2:
                    // listarInfoMedicos();
                    consultarClassificacoesOrdenadas();
                    break;
                case 3:
                    sair = false;
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

    }

    /////////////////////////////////////////////////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////        OUTPUT DE LISTAGEM     ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    /////////////////////////////////////////////////////

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

    public static void listarInfoMedicos() {

        for(int i = 0; i < medicos.size(); i++) {

            System.out.println("////////////////////////////////////");

            System.out.println("NÚMERO DE MÉDICO: " + medicos.get(i).getNumeroMedico());
            System.out.println("Nome: " + medicos.get(i).getNome());
            System.out.println("Idade: " + medicos.get(i).getIdade());
            System.out.println("Especialidade: " + medicos.get(i).getEspecialidade());
            System.out.println("Avaliação média: " + medicos.get(i).getAvaliacaoMedia());

            System.out.println("////////////////////////////////////");

        }

    }

    public static void listarInfoMedicos(List<Medico> listaFiltrada) {

        for(int i = 0; i < listaFiltrada.size(); i++) {

            System.out.println("////////////////////////////////////");

            System.out.println("NÚMERO DE MÉDICO: " + listaFiltrada.get(i).getNumeroMedico());
            System.out.println("Nome: " + listaFiltrada.get(i).getNome());
            System.out.println("Idade: " + listaFiltrada.get(i).getIdade());
            System.out.println("Especialidade: " + listaFiltrada.get(i).getEspecialidade());
            System.out.println("Avaliação média: " + listaFiltrada.get(i).getAvaliacaoMedia());

            System.out.println("////////////////////////////////////");

        }

    }

//    public static void listarInfoMedicosFiltrados(List<Medico> listaFiltrada) {
//
//        for(int i = 0; i < listaFiltrada.size(); i++) {
//
//            System.out.println("NÚMERO DE MÉDICO: " + listaFiltrada.get(i).getNumeroMedico());
//            System.out.println("Nome: " + listaFiltrada.get(i).getNome());
//            System.out.println("Idade: " + listaFiltrada.get(i).getIdade());
//            System.out.println("Especialidade: " + listaFiltrada.get(i).getEspecialidade());
//
//            System.out.println("////////////////////////////////////");
//
//        }
//
//    }

}
