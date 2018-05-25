package centromedicopoo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.DecimalFormat;
import java.io.*;

public class CentroMedico extends CentroMedicoPOO {
    private String nome;
    private int ano_fundacao;
    private static int consultas_marcadas = 0;
    private static final int LIMITE_CONSULTAS = 12;

    private static ArrayList<Utente> utentes;
    private static ArrayList<Medico> medicos;
    private static ArrayList<Consulta> consultas;

    private static int contadorInstanciasNumeroUtente = 0;
    private static int contadorInstanciasNumeroMedico = 0;
    private static int contadorInstanciasNumeroConsulta = 0;

    private static String diaAtual = "30/05/2018";

    private static final String FICHEIRO_UTENTES = "utentes.txt";
    private static final String FICHEIRO_MEDICOS = "medicos.txt";
    private static final String FICHEIRO_CONSULTAS = "consultas.txt";

    private static final int precoConsulta = 50;
    private static final int precoExame = 30;

    public CentroMedico(){
        nome = "Centro Medico da UMA";
        ano_fundacao = 1980;
        utentes = new ArrayList<Utente>();
        medicos = new ArrayList<Medico>();
        consultas = new ArrayList<Consulta>();
    }

    /**
     * Adiciona utentes à lista
     * @param utente classe Utente com um conjunto de dados
     */

    public static void addUtente(Utente utente){
        utentes.add(utente);
    }

    /**
     * Devolve uma lista de todos os utentes
     * @return todos os utentes
     */

    public static ArrayList<Utente> getUtentes(){
        return utentes;
    }

    /**
     * Adiciona médicos à lista
     * @param medico classe Médico com um conjunto de dados
     */

    public static void addMedico(Medico medico){
        medicos.add(medico);
    }

    /**
     * Devolve uma lista de todos os médicos
     * @return todos os médicos
     */

    public static ArrayList<Medico> getMedicos(){
        return medicos;
    }

    /**
     * Adiciona uma consulta à lista
     * @param consulta classe Consulta com um conjunto de dados
     */

    public static void addConsulta(ConsultaDiagnostico consulta){
        consultas.add(consulta);
    }

    /**
     * Devolve uma lista de todas as consultas
     * @return todas as consultas
     */

    public static ArrayList<Consulta> getConsultas(){
        return consultas;
    }

    /**
     * Devolve um booleano se uma consulta pode, ou não, ser marcada. Verificamos isto ao passar pela lista de
     * consultas e comparamos a data (...)
     * @param data data em formato DD/MM/AAAA
     * @param numeroMedico número único do médico
     * @return booleano se pode ou não marcar uma consulta
     */

    //metodo para verificar se o medico atingiu o limite de consultas para determinado dia
    public static boolean podeMarcarConsulta(String data, int numeroMedico){
        for(int i = 0; i < consultas.size(); i++){
            if( (consultas.get(i).getData().equals(data)) && (consultas.get(i).getNumeroMedico() == numeroMedico) ){
                consultas_marcadas++;
            } 
        }
        if(consultas_marcadas == LIMITE_CONSULTAS){
            return false;
        }else{
            return true;
        }
    }

    public static boolean realizouConsultaDiag(String diaAtual, int numeroConsulta){
        for(int i = 0; i < consultas.size(); i++){
            if( consultas.get(i).getData().equals(diaAtual) && consultas.get(i).getNumeroConsulta() == numeroConsulta ){
                return true;
            }
        }
        return false;
    }

    public static boolean realizarPagamentoAposResultado(int numeroConsulta){
        //boolean realizar_pagamentos_apos_diagnostico = false;
        boolean realizar_pagamentos_apos_resultado = false;
        int numero_consultas = 0;

        for(int i = 0; i < consultas.size(); i++){
            if(consultas.get(i).getNumeroConsulta() == numeroConsulta){
                numero_consultas++;
            }
        }
        if(numero_consultas >= 2){
            realizar_pagamentos_apos_resultado = true;
        }else{
            realizar_pagamentos_apos_resultado = false;
        }
        return realizar_pagamentos_apos_resultado;
    }
    
    /**
     * Adiciona um utente à lista de utentes do centro médico
     */

    public static void adicionarUtente() {

        String nome;
        int idade;
        int numeroUtente;
        String utentesAngariados;
        String temSeguro;

        // Booleano que serve apenas de condição para adicionar um novo utente
        boolean seguroInvalido = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");

        Utente utente = new Utente();

        System.out.print("Nome: ");
        nome = entradaDados.nextLine();
        
        System.out.print("Idade: ");
        idade = entradaDados.nextInt();

        System.out.print("O utente foi indicado por outro utente? S/N: " + "\n");

        utentesAngariados = entradaDados.nextLine();
        utentesAngariados = entradaDados.nextLine();

        if (utentesAngariados.equals("S") || utentesAngariados.equals("s")) {
            utente.setUtentesAngariados(true);
        }
        else if (utentesAngariados.equals("N") || utentesAngariados.equals("n")) {
            utente.setUtentesAngariados(false);
        }
        else {
            System.out.println("Valor inválido. Inserção de dados interrompida. Voltamos ao menu principal.");
            return;
        }

        System.out.print("O utente tem seguro? S/N: " + "\n");

        /* Tem que haver 2 linhas que fazem a mesma tarefa porque
        caso contrário não funciona */

        // temSeguro = entradaDados.nextLine();
        temSeguro = entradaDados.nextLine();

        /* Condição para saber se a letra inserida corresponde a um
        valor válido ou não. Também já pode atribuir um booleano (temSeguro)
        ao novo utente que vai (ou não) ser adicionado ao centro médico */

        if (temSeguro.equals("S") || temSeguro.equals("s")) {
            utente.setTemSeguro(true);
            // utente.setDescontoAcumulado(0.40); // EDITAR ISTO
            // System.out.print("CONFIRMO QUE O UTENTE TEM SEGURO" + "\n"); // APENAS PARA TESTES
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

        System.out.print("Nome: ");
        nome = entradaDados.nextLine();

        System.out.print("Idade: ");
        idade = entradaDados.nextInt();

        System.out.print("Especialidade: ");

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

    /**
     * Adiciona uma consulta à lista de consultas
     * @throws ParseException fundamental devido à conversão de String para SimpleDateFormat no método verificaData
     * na classe Consulta
     */

    public static void adicionarConsulta() throws ParseException {
        //para facilitar os testes, criacao de objectos utente e medico
        Utente utente1 = new Utente("Joao", 28, 33, true);
        Medico medico1 = new Medico("Luis", 99, 22, "Pediatria");

        int numeroUtente;
        int numeroMedico;
        String data_diagnostico, data_resultado;
        String consulta_resultado;
        String exame;
        long diferenca_entre_dias;
        boolean consulta_unica = true;

        boolean numeroUtenteCorrecto = false;
        boolean numeroMedicoCorrecto = false;

        Scanner entradaDados = new Scanner(System.in, "Cp1252");

        //declaração de variáveis do tipo consulta, onde vamos associar instâncias de consultaDiagnostico e consultaResultado (note-se o polimorfismo)
        Consulta consultaDiagnostico, consultaResultado;
        consultaDiagnostico = new ConsultaDiagnostico();
        consultaResultado = new ConsultaResultado();

        System.out.print("Insira o numero do utente que pretende adicionar à consulta: ");
        numeroUtente = entradaDados.nextInt();

        for(int i = 0; i < utentes.size(); i++){
            if(utentes.get(i).getNumeroUtente() == numeroUtente){
                numeroUtenteCorrecto = true;
                break;
            }else{
                numeroUtenteCorrecto = false;
            }
        }
        if(numeroUtenteCorrecto){
            System.out.println("O numero esta correcto");
        }else{
            System.out.println("O numero esta errado");
        }

        System.out.print("Insira o numero do medico para este utente: ");
        numeroMedico = entradaDados.nextInt();

        //percore a lista dos medicos e verifica se o numeroMedico de input existe
        for(int i = 0; i < medicos.size(); i++){
            if(medicos.get(i).getNumeroMedico() == numeroMedico) {
                numeroMedicoCorrecto = true;
                break;
            }else{
                numeroMedicoCorrecto = false;
            }
        }
        //para só fazer display uma vez
        if(numeroMedicoCorrecto){
            System.out.println("O numero esta correcto.");
        }else{
            System.out.println("O numero esta errado.");
        }

        //verificar se o limite de consultas por dia para determinado médico já foi atingido
        //if(getConsultas())

        //String data = entradaDados.next();
        System.out.println("Insira a data para esta consulta, Formato: dd/MM/aaaa");
        data_diagnostico = entradaDados.next();
        Date data_diag = consultaDiagnostico.getDate(data_diagnostico);

        if( consultaDiagnostico.verificaData(data_diagnostico) && numeroMedicoCorrecto && numeroUtenteCorrecto ){
            consultaDiagnostico.setDataConsulta(data_diagnostico);
            consultaDiagnostico.setNumeroUtente(numeroUtente);
            consultaDiagnostico.setNumeroMedico(numeroMedico);
            // consultaDiagnostico.setConsultaUnica(consulta_unica);
            if( podeMarcarConsulta(data_diagnostico,numeroMedico) ){
                contadorInstanciasNumeroConsulta++;
                consultaDiagnostico.setNumeroConsulta(contadorInstanciasNumeroConsulta);
                consultas.add(consultaDiagnostico);
                System.out.println("A consulta foi marcada com sucesso. " + "Numero de Utente: " + numeroUtente + " Numero do Medico: " + numeroMedico + " Data: " + data_diagnostico + " Numero da Consulta: " + contadorInstanciasNumeroConsulta);
            }else{
                System.out.println("O limite de consultas diárias para o médico numero: " + numeroMedico + " foi atingido");
            }
            if( realizouConsultaDiag(diaAtual,contadorInstanciasNumeroConsulta) ){
                System.out.print("Pretende solicitar exame? ");
                exame = entradaDados.next();
                if(exame.equals("s") || exame.equals("S")){
                    System.out.println("O exame estará pronto dentro de 7 dias");
                }else{
                    return;
                }
                System.out.print("Insira a data pretendida para a consulta de resultado: ");
                data_resultado = entradaDados.next();
                Date data_resul = consultaDiagnostico.getDate(data_resultado);
                diferenca_entre_dias = consultaDiagnostico.diferencaDias(data_resul,data_diag);
                if( consultaResultado.verificaData(data_resultado) ){
                    if( diferenca_entre_dias >= 8 ){
                        consultaResultado.setDataConsulta(data_resultado);
                        consultaResultado.setNumeroMedico(numeroMedico);
                        consultaResultado.setNumeroUtente(numeroUtente);
                        consultaResultado.setNumeroConsulta(contadorInstanciasNumeroConsulta);
                        consultas.add(consultaResultado);
                        //System.out.println("A consulta de resultados foi marcada para o dia: " + data_resultado);
                        System.out.println("A consulta de resultado foi marcada com sucesso. " + "Numero de Utente: " + numeroUtente + " Numero do Medico: " + numeroMedico + " Data: " + data_diagnostico + " Numero da Consulta: " + contadorInstanciasNumeroConsulta);
                    }else{
                        System.out.println("A consulta de resultados só poderá ser marcada 8 dias após a consulta de diagnóstico.");
                    }
                }else{
                    System.out.println("A data é inválida");
                }
            }else{
                System.out.println("Esta consulta aguarda realização, então poderá ser solicitado um exame e marcada uma consulta de resultados");
            }
        }
    }
    
    
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
            FileReader inStreamConsultas = new FileReader(FICHEIRO_CONSULTAS);
            FileReader inStreamAdicionarConsultas = new FileReader(FICHEIRO_CONSULTAS);

            BufferedReader bRUtentes = new BufferedReader(inStreamUtentes);
            BufferedReader bRMedicos = new BufferedReader(inStreamMedicos);
            BufferedReader bRConsultas = new BufferedReader(inStreamConsultas);
            BufferedReader bRAdicionarConsultas = new BufferedReader(inStreamAdicionarConsultas);

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

            /////////////////// Ficheiro Consultas ///////////////////

            int numeroLinhasFicheiro = 0;
            String leituraNumeroDeLinhas = bRConsultas.readLine();


            while(leituraNumeroDeLinhas != null) {
                leituraNumeroDeLinhas = bRConsultas.readLine();
                numeroLinhasFicheiro++;
            }

            consultas_marcadas = numeroLinhasFicheiro + consultas_marcadas;
            bRConsultas.close();

            String leituraConsultaLinha = bRAdicionarConsultas.readLine();

            while (leituraConsultaLinha != null) {

                String[] campos = leituraConsultaLinha.split(","); // delimitador
                leituraConsultaLinha = bRAdicionarConsultas.readLine();

                int numUtente = Integer.parseInt(campos[0]);
                int numMedico = Integer.parseInt(campos[1]);
                String dataDiag = campos[2];

                Consulta novaConsultaDoFicheiro = new Consulta(numUtente, numMedico, dataDiag);

                consultas.add(novaConsultaDoFicheiro);

            }

//            if (consultas_marcadas < consultasMarcadasDoFicheiro + consultas_marcadas) {
//                System.out.println("Importação ")
//            }


            bRAdicionarConsultas.close();

        }

        catch(IOException ioe) {
            System.out.println("Ocorreu um erro!");
        }
    }

    /**
     * Deposita crédito na conta de um utente desejado pelo utilizador.
     */

    public static void depositarCredito() {

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        boolean numeroUtenteCorrecto = false;
        int numeroUtente;
        double quantiaCredito;
        double somaCredito;
        Utente utenteCredito = new Utente();

        System.out.println("Insira o numero de utente que quer depositar o crédito: ");
        numeroUtente = entradaDados.nextInt();

        for(int i = 0; i < utentes.size(); i++){
            if(utentes.get(i).getNumeroUtente() == numeroUtente){
                numeroUtenteCorrecto = true;
                utenteCredito = utentes.get(i);
                break;
            }else{
                numeroUtenteCorrecto = false;
            }
        }
        if(numeroUtenteCorrecto){
            System.out.println("O numero esta correcto");
        }else{
            System.out.println("O numero esta errado");
            return;
        }

        System.out.println("Quanto crédito deseja depositar?");
        quantiaCredito = entradaDados.nextDouble();

        somaCredito = quantiaCredito + utenteCredito.getCreditoCM();

        utenteCredito.setCreditoCM(somaCredito);

    }

    /**
     * Retira crédito de uma conta de um utente desejado pelo utilizador.
     * NOTA: Este método não tem qualquer utilidade, no entanto, podia ser aproveitado para alguma coisa.
     */

    public static void retirarCredito() {

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        boolean numeroUtenteCorrecto = false;
        int numeroUtente;
        double quantiaCredito;
        double subtrCredito;
        Utente utenteCredito = new Utente();

        System.out.println("Insira o numero de utente que quer retirar o crédito: ");
        numeroUtente = entradaDados.nextInt();

        for(int i = 0; i < utentes.size(); i++){
            if(utentes.get(i).getNumeroUtente() == numeroUtente){
                numeroUtenteCorrecto = true;
                utenteCredito = utentes.get(i);
                break;
            }else{
                numeroUtenteCorrecto = false;
            }
        }
        if(numeroUtenteCorrecto){
            System.out.println("O numero esta correcto"); // ajustar isto
        }else{
            System.out.println("O numero esta errado");
            return;
        }

        System.out.println("Quanto crédito deseja retirar?");
        quantiaCredito = entradaDados.nextDouble();

        subtrCredito = utenteCredito.getCreditoCM() - quantiaCredito;

        utenteCredito.setCreditoCM(subtrCredito);

    }

    /**
     * Atribuição do dia que irá ser "simulado".
     */

    public static void escolherDia() {

        Scanner entradaDados = new Scanner(System.in,"Cp1252");

        System.out.println("Introduza o dia desejado: (formato DD/mm/aaaa)");
        String dia = entradaDados.nextLine();

        diaAtual = dia;

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

    public static void menuPrincipal() throws ParseException {

        boolean sair = true;

        //////////////////////////////////////////////////////////////
        CentroMedico centroTeste = new CentroMedico();
        // Medico medicoAvaliado = new Medico("Ana", 32, 102346,"Urologia");
        // Medico medicoAvaliadoDois = new Medico("Bruno", 47, 103469, "Pediatria");
        
        // medicos.add(medicoAvaliado);
        // medicos.add(medicoAvaliadoDois);

        //Utente utenteConsulta = new Utente("Carlota",46,39123,0,0,true,null);
        //Utente utenteConsultaDois = new Utente("Carlos",20,39122,0,0,false,null);
 
        //utentes.add(utenteConsulta);
        //utentes.add(utenteConsultaDois);

        // Os indivíduos acima são só para fins de teste. //

        do {

            System.out.println("Data: " + diaAtual + "\n"
                    + "1 - Registar um novo utente\n"
                    + "2 - Registar um novo médico\n"
                    + "3 - Marcar uma nova consulta (diagnóstico e/ou resultado)\n"
                    + "4 - Realizar uma nova consulta (diagnóstico e/ou resultado)\n"
                    + "5 - Listar utentes\n"
                    + "6 - Listar médicos\n"
                    + "7 - Valor total que o centro médico já recebeu dos utentes\n"
                    + "8 - Número de consultas que o centro médico já realizou\n"
                    + "9 - Sair do programa\n"
                    + "10 - !!! DEBUGGING !!! - Atribuir avaliação a um médico\n"
                    + "11 - Alterar o dia atual\n"
                    + "12 - !!! DEBUGGING !!! - Ler o ficheiro com dados dos utentes\n"
                    + "13 - !!! DEBUGGING !!! - Listar todas as consultas marcadas até a data\n"
                    + "14 - Gerir crédito de um utente\n");
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
                    realizarPagamentos();
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
                    // avaliarAlguem(medicoAvaliado);
                    // avaliarAlguem(medicoAvaliadoDois);
                    break;
                case 11:
                    escolherDia();
                    break;
                case 12:
                    insereDadosFicheirosTexto();
                    break;
                case 13:
                    listarConsultasMarcadas();
                    break;
                case 14:
                    menuGerirCredito();
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

    /**
     * Menu de gestão do crédito
     */

    public static void menuGerirCredito() {

        boolean sair = true;

        do {

            System.out.println("----- Gestão de crédito -----\n"
                    + "1 - Depositar crédito\n"
                    + "2 - Retirar crédito\n"
                    + "3 - Voltar atrás\n");

            Scanner entradaDados = new Scanner(System.in, "Cp1252");
            int op;

            System.out.print("Escolha uma opção: ");
            op = entradaDados.nextInt();

            switch(op) {
                case 1:
                    depositarCredito();
                    break;
                case 2:
                    retirarCredito();
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
        System.out.println("Este centro medico tem os seguintes utentes: " + "\n" + getUtentes() );
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

    /**
     * Listagem das consultas marcadas e, quantas é que foram marcadas.
     */

    public static void listarConsultasMarcadas(){
        System.out.println("Este centro medico tem as seguintes consultas marcadas: "+"\n"+getConsultas()+"\n"+ "Numero de consultas: "+getConsultas().size()+"\n");
    }

    public static void realizarPagamentos(){
        int numeroConsulta;
        Scanner scan = new Scanner(System.in,"cp1252");
        System.out.println("Introduza o número da consulta a pagar.");
        numeroConsulta = scan.nextInt();
        if(realizarPagamentoAposResultado(numeroConsulta)){

            // chama calculaCustos e debitaCreditoTresFases aqui
            System.out.println("Pagamento referente a consulta de diagnósticos e resultados efectuado.");

        }else{

            // chama calculaCustos e debitaCredito aqui
            System.out.println("Pagamento referente a consulta de diagnósticos efectuado.");
        }
    }

}
