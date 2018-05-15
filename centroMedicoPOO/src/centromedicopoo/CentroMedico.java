package centromedicopoo;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.text.DecimalFormat;

import java.io.*;

public class CentroMedico extends CentroMedicoPOO {

    private static List<Utente> utentes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();

    private static int contadorInstanciasNumeroUtente = 0;
    private static int contadorInstanciasNumeroMedico = 0;

    private static final String FICHEIRO_UTENTES = "utentes.txt";
    private static final String FICHEIRO_MEDICOS = "medicos.txt";
    private static final String FICHEIRO_CONSULTAS = "consultas.txt";


    // private static Utente numberlist;

    /**
     * Adiciona um utente à lista de utentes do centro médico
     */

    public static void adicionarUtente() {

        String nome;
        int idade;
        int numeroUtente;
        String temSeguro;

        // Booleano que serve apenas de condição para adicionar um novo utente
        boolean seguroInvalido = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");

        Utente utente = new Utente();

        System.out.print("Nome: " + "\n");
        nome = entradaDados.nextLine();
        
        System.out.print("Idade: " + "\n");
        idade = entradaDados.nextInt();

        System.out.print("O utente tem seguro? S/N: " + "\n");

        /* Tem que haver 2 linhas que fazem a mesma tarefa porque
        caso contrário não funciona */

        temSeguro = entradaDados.nextLine();
        temSeguro = entradaDados.nextLine();

        /* Condição para saber se a letra inserida corresponde a um
        valor válido ou não. Também já pode atribuir um booleano (temSeguro)
        ao novo utente que vai (ou não) ser adicionado ao centro médico */

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

        /* A condição é verdadeira se e só se um valor inválido foi
        escrito na pergunta anterior (se tem seguro ou não) */

        if(!seguroInvalido) {

            /* Esta incrementação diz-nos que um novo utente vai ser adicionado
            ao centro médico e este contador vai servir de número de utente */

            contadorInstanciasNumeroUtente++;
            numeroUtente = contadorInstanciasNumeroUtente;

            utente.setNome(nome);
            utente.setIdade(idade);
            utente.setNumeroUtente(numeroUtente);

            utentes.add(utente); // Utente adicionado à lista de utentes

            /// TESTES ///
            // System.out.print(utenteTeste.getNome());
            // System.out.print(utenteTeste.getIdade());
        }
        
    }

    /**
     * Adiciona um médico à lista de médicos do centro médico
     */

    public static void adicionarMedico() {

        String nome;
        int idade;
        int numeroMedico;
        String especialidade;

        /* registaMedico só serve para detectar se os dados inseridos estão corretos
        especialidadeInvalida só serve para detectar se uma especialidade inserida existe
        no centro médico */
        boolean registaMedico = false;
        boolean especialidadeInvalida = true;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        Medico medico = new Medico();

        System.out.println("Nome: " + "\n");
        nome = entradaDados.nextLine();

        System.out.println("Idade: " + "\n");
        idade = entradaDados.nextInt();

        System.out.println("Especialidade: " + "\n");

        /* Tem que haver 2 linhas que fazem a mesma tarefa porque
        caso contrário não funciona */

        especialidade = entradaDados.nextLine();
        especialidade = entradaDados.nextLine();

        /* Ciclo for para verificar se a especialidade inserida existe */

        for(int i = 0; i < Medico.especialidades.length; i++) {
            if(especialidade.equals(Medico.especialidades[i])) {
                // medicoTeste.setEspecialidade(especialidade);
                registaMedico = true;
                especialidadeInvalida = false;
            }

        }

        // testes
        if(especialidadeInvalida){
            System.out.println("ESPECIALIDADE INVALIDA. Inserção de dados interrompida."); // APENAS TESTES
            // registaMedico = false;
            // menuPrincipal();
        }

        /* A condição é verdadeira se e só se um valor inválido foi
        escrito na pergunta anterior (se a especialidade existe ou não) */

        if(registaMedico) {

            /* Esta incrementação diz-nos que um novo médico vai ser adicionado
            ao centro médico e este contador vai servir de número de médico */

            contadorInstanciasNumeroMedico++;
            numeroMedico = contadorInstanciasNumeroMedico;

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
        //para facilitar os testes, criacao de objectos utente e medico
        Utente utente1 = new Utente("Joao", 28, 33, true);
        Medico medico1 = new Medico("Luis", 99, 22, "Pediatria");

        int numeroUtente;
        int numeroMedico;
        String data;

        boolean numeroUtenteCorrecto = false;
        boolean numeroMedicoCorrecto = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");
        ConsultaDiagnostico novaConsultaDiag = new ConsultaDiagnostico();

        System.out.println("Insira o numero do utente que pretende adicionar à consulta");
        numeroUtente = entradaDados.nextInt();

        for(int i = 0; i < utentes.size(); i++){
            if(utentes.get(i).getNumeroUtente() == numeroUtente){
                numeroUtenteCorrecto = true;
                System.out.println("O numero esta correcto");
            }else{
                numeroUtenteCorrecto = false;
                System.out.println("O numero esta errado");
            }
        }

        System.out.println("Insira o numero do medico para este utente");
        numeroMedico = entradaDados.nextInt();

        for(int i = 0; i < medicos.size(); i++){
            if(medicos.get(i).getNumeroMedico() == numeroMedico) {
                numeroMedicoCorrecto = true;
                System.out.println("O numero esta correcto");
            }else{
                numeroMedicoCorrecto = false;
                System.out.println("O numero esta errado");
            }
        }


        //String data = entradaDados.next();
        do{
            System.out.println("Insira a data para esta consulta, Formato: dd/MM/yyyy");
            data= entradaDados.next();
        } while( !novaConsultaDiag.verificaData(data) );

        if( novaConsultaDiag.verificaData(data) ){
            novaConsultaDiag.setDataConsulta(data);
            System.out.println("A consulta foi marcada com sucesso.");
        }
        else{
            System.out.println("A data e invalida");
        }


        /**
         if( novaConsultaDiag.isValidDate(data) ){
         System.out.println("A data introduzida é valida");
         }else{
         System.out.println("A data introduzida é inválida");
         }**/

    }

    // public static void listarPagamentosUtentes() { }

    // public static int numeroConsultasFeitas() { }

    /**
     * Cria uma lista filtrada de médicos com uma
     * especialidade inserida pelo utilizador
     */

    public static void consultarEspecialidadeMedico() {

        String especialidade;

        /* encontreiEspecialidade serve para detectar se uma especialidade inserida existe
        no centro médico */
        boolean encontreiEspecialidade = false;

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        System.out.println("Escolha uma especialidade: ");
        especialidade = entradaDados.nextLine();

        /* O ciclo for procura pela especialidade inserida
        pelo utilizador */

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

        /* Caso o ciclo for tenha encontrado uma especialidade, é criada
        a lista filtrada com médicos (com a dada especialidade pelo utlizador) */

        List<Medico> listaFiltradaCopiada = medicos.stream()
                .filter(p -> p.getEspecialidade().equals(especialidade))
                .collect(Collectors.toList());

        listarInfoMedicos(listaFiltradaCopiada);

    }

    /**
     * Calcula a média das avaliações de um dado médico
     * @param nota soma das notas
     * @param avaliacoes número de avaliações
     * @return média de avaliações de um médico
     */

    public static double calculaMedia(double nota, int avaliacoes) {
        return nota/avaliacoes;
    }

    /**
     * Avalia um médico com o input de um número
     * @param medico instância de um médico
     */

    public static void avaliarAlguem(Medico medico) {

        double nota;
        double media;
        DecimalFormat mediaArredondada = new DecimalFormat(".##"); // 2 casas decimais

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        System.out.println("Avaliação (inteiro): ");
        nota = entradaDados.nextDouble();

        medico.setNumAvaliacoes(medico.getNumAvaliacoes() + 1); // incrementa número de avaliações feitas
        medico.setSomaNotas(medico.getSomaNotas() + nota); // soma o total das notas

        media = calculaMedia(medico.getSomaNotas(), medico.getNumAvaliacoes()); // re-calcula a média
        System.out.println("A média calculada: " + mediaArredondada.format(media));

        medico.setAvaliacaoMedia(media);

        // return;

    }

    /**
     * Ordena uma lista de médicos pela sua classificação média e dá o seu output
     */

    public static void consultarClassificacoesOrdenadas() {

        List<Medico> listaOrdenadaClassificacao = new ArrayList<>(medicos);

        listaOrdenadaClassificacao.sort(Comparator.comparingDouble(Medico::getAvaliacaoMedia)
                .reversed());

        listarInfoMedicos(listaOrdenadaClassificacao);

    }

    // public static void avancaUmDia() { }

    /**
     * Lê 3 ficheiros com informação de utentes, médicos e consultas, respetivamente, 1 a 1.
     * Em cada leitura, toda a informação é escrita numa lista adequada a quem diz a respeito.
     */

    public static void insereDadosFicheirosTexto() {

        // o método tem que iterar os 3 ficheiros e pôr a informação toda nas listas

        try {

            FileReader inStreamUtentes = new FileReader(FICHEIRO_UTENTES);
            FileReader inStreamMedicos = new FileReader(FICHEIRO_MEDICOS);
            // FileReader inStreamConsultas = new FileReader(FICHEIRO_CONSULTAS);

            BufferedReader bRUtentes = new BufferedReader(inStreamUtentes);
            BufferedReader bRMedicos = new BufferedReader(inStreamMedicos);
            // BufferedReader bRConsultas = new BufferedReader(inStreamConsultas);

            /////////////////// Ficheiro Utentes ///////////////////

            String leituraUtenteLinha = bRUtentes.readLine();

            while (leituraUtenteLinha != null) {

                String[] campos = leituraUtenteLinha.split(","); // delimitador
                leituraUtenteLinha = bRUtentes.readLine();

                String nome = campos[0];
                int idade = Integer.parseInt(campos[1]);
                String temSeguro = campos[2];

                /* Lê a letra atribuída ao seguro e substitui por true ou
                 * false, dependendo da letra */

                boolean temSeguroBool = false;

                if (temSeguro.equals("S") || temSeguro.equals("s")) {
                    temSeguroBool = true;
                    // utente.setDescontoAcumulado(0.40); // EDITAR ISTO
                    System.out.print("CONFIRMO QUE O UTENTE TEM SEGURO"); // APENAS PARA TESTES
                    // ATRIBUI DESCONTO
                }
                else if (temSeguro.equals("N") || temSeguro.equals("n")) {
                    temSeguroBool = false;
                }

                /* Esta incrementação diz-nos que um novo utente vai ser adicionado
                ao centro médico e este contador vai servir de número de utente */

                int numeroUtente;

                contadorInstanciasNumeroUtente++;
                numeroUtente = contadorInstanciasNumeroUtente;

                Utente novoUtenteDoFicheiro = new Utente(nome, idade, numeroUtente, temSeguroBool);

                utentes.add(novoUtenteDoFicheiro);  // Um novo utente foi adicionado

            }

            bRUtentes.close();

            /////////////////// Ficheiro Médicos ///////////////////

            String leituraMedicoLinha = bRMedicos.readLine();

            while (leituraMedicoLinha != null) {

                String[] campos = leituraMedicoLinha.split(","); // delimitador
                leituraMedicoLinha = bRMedicos.readLine();

                String nome = campos[0];
                int idade = Integer.parseInt(campos[1]);
                String especialidade = campos[2];

                /* Esta incrementação diz-nos que um novo médico vai ser adicionado
                ao centro médico e este contador vai servir de número de médico */

                int numeroMedico;

                contadorInstanciasNumeroMedico++;
                numeroMedico = contadorInstanciasNumeroMedico;

                Medico novoMedicoDoFicheiro = new Medico(nome, idade, numeroMedico, especialidade);

                medicos.add(novoMedicoDoFicheiro);   // médico foi adicionado

            }

            bRMedicos.close();

        }

        catch(IOException ioe) {
            System.out.println("Ocorreu um erro!");
        }
    }


    /////////////////////////////////////////////////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////        OUTPUT DE MENUS        ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    ///////////                               ///////////
    /////////////////////////////////////////////////////

    /**
     * Menu principal da aplicação.
     */

    public static void menuPrincipal() {

        boolean sair = true;

        //////////////////////////////////////////////////////////////

        Medico medicoAvaliado = new Medico("Ana", 32, 102346,"Urologia");
        Medico medicoAvaliadoDois = new Medico("Bruno", 47, 103469, "Pediatra");

        medicos.add(medicoAvaliado);
        medicos.add(medicoAvaliadoDois);

        Utente utenteConsulta = new Utente("Carlota",46,39123,0,0,0,true,null);
        Utente utenteConsultaDois = new Utente("Carlos",20,39122,0,0,0,false,null);

        utentes.add(utenteConsulta);
        utentes.add(utenteConsultaDois);

        // Os indivíduos acima são só para fins de teste. //

        do {

            System.out.println("1 - Registar um novo utente\n"
                    + "2 - Registar um novo médico\n"
                    + "3 - Realizar uma nova consulta de diagnóstico\n"
                    + "4 - Realizar uma nova consulta de resultados\n"
                    + "5 - Listar utentes\n"
                    + "6 - Listar médicos\n"
                    + "7 - Valor total que o centro médico já recebeu dos utentes\n"
                    + "8 - Número de consultas que o centro médico já realizou\n"
                    + "9 - Sair do programa\n"
                    + "10 - !!! DEBUGGING !!! - Atribuir avaliação a um médico\n"
                    + "11 - Avançar um dia\n"
                    + "12 - !!! DEBUGGING !!! - Ler o ficheiro com dados dos utentes\n");

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
                case 12:
                    insereDadosFicheirosTexto();
                    break;
                default:
                    System.out.println("\nValor inválido\n");
            }

        } while(sair);

    }

    /**
     * Menu de listagem de utentes.
     */

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

    /**
     * Menu de listagem de médicos
     */

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

    /**
     * Listagem de todos os utentes no centro médico com o seu número de utente,
     * nome, idade e se tem ou não seguro.
     */

    public static void listarInfoUtentes() {

        if (utentes.isEmpty()) {
            System.out.println("Não existem utentes.");
        }

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

    /**
     * Listagem de médicos a trabalhar no centro médico com o seu número de médico,
     * nome, idade, especialidade e avaliação média
     * @param listaFiltrada lista que contém um dado número de médicos, pode ter (ou não) passado por um filtro previamente
     */

    public static void listarInfoMedicos(List<Medico> listaFiltrada) {

        if (medicos.isEmpty()) {
            System.out.println("Não existem medicos.");
        }

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

}
