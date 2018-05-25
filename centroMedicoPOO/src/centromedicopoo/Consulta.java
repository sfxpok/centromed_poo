package centromedicopoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta {
    
    private int numeroUtente;
    private int numeroMedico;
    private String data;
    private double custoConsulta;

    ////////////////////////// *** Construtores *** //////////////////////////

    public Consulta(int numeroUtente, int numeroMedico, String data, double custoConsulta) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.data = data;
        this.custoConsulta = custoConsulta;
    }

    public Consulta () {
        
    }

    public Consulta(int numeroUtente, int numeroMedico, String data) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.data = data;
    }

    ////////////////////////// *** Getters e setters *** //////////////////////////

    /**
     * Devolve o número de utente
     * @return número de utente
     */

    public int getNumeroUtente(){
        return numeroUtente;
    }

    /**
     * Devolve o número de médico
     * @return número de médico
     */

    public int getNumeroMedico(){
        return numeroMedico;
    }

    /**
     * Devolve o custo da consulta
     * @return custo da consulta
     */

    public double getCustoConsulta() {
        return custoConsulta;
    }

    /**
     * Atribui um número de utente
     * @param numeroUtente número de utente único
     */

    public void setNumeroUtente(int numeroUtente){
        this.numeroUtente = numeroUtente;
    }

    /**
     * Atribui um número de médico
     * @param numeroMedico número de médico único
     */

    public void setNumeroMedico(int numeroMedico){
        this.numeroMedico = numeroMedico;
    }

    /**
     * Atribui um custo a uma consulta
     * @param custoConsulta custo de uma consulta
     */

    public void setCustoConsulta(double custoConsulta) {
        this.custoConsulta = custoConsulta;
    }

    /**
     * Devolve a data de cada consulta
     * @return data da consulta
     */

    public String getData(){
        return data;
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    
    public boolean solicitaExame(){
        return true;
    } // caso o médico solicite um exame

    /*public void addUtente(Utente utente){
        utentes.add(utente);
    } // adicionar um utente à consulta

    public void addMedico(Medico medico){
        medicos.add(medico);
    } // adicionar um médico à consulta*/

    /**
     * Atribui uma data à consulta
     * @param data data da consulta
     */

    public void setDataConsulta(String data){
        this.data = data;
    } // adicionar uma data à consulta

    /**
     * O método recebe uma data (DD/MM/AAAA) no tipo de dado String e devolve no tipo de dado
     * SimpleDateFormat que corresponde a uma data.
     * @param data data de uma consulta no tipo de dado String
     * @return booleano se a data foi escrita de forma correta
     */

    public boolean verificaData(String data)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        /* declarar e inicializar variável testeData, esta variável vai conter
         * o valor da string convertida */

        Date testeData = null;

        // tentar fazer o parsing da string para o formato data
        try
        {
            testeData = sdf.parse(data);
        }
        // se o formato da string disponibilizada nao for equivalente ao formato declarado em SimpleDateFormat() teremos uma excepçao
        catch (ParseException e)
        {
            String mensagemErro = "A data inserida está num formato inválido";
            return false;
        }
        if (!sdf.format(testeData).equals(data))
        {
            String mensagemErro = "A data inserida é inválida";
            return false;
        }
        // se chegarmos até aqui nas verificações iremos assumir que o formato da data está correcta
        return true;
    }

    /**
     * Parsing de uma data de String para Date
     * @param date data da consulta
     * @return Data no argumento no tipo de dado Date
     * @throws ParseException
     */

    public static Date getDate(String date) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        return df.parse(date);
    }

    /**
     * Diferença entre dois dias introduzidos
     * @param dataInicio ponto inicial de comparação
     * @param dataFinal ponto final de comparação
     * @return diferença de dias
     */

    public long diferencaDias(Date dataInicio, Date dataFinal){
        long diferenca = ( dataInicio.getTime() - dataFinal.getTime() ) / 86400000;
        return Math.abs(diferenca);
    }

    /**
     * Devolve informação relevante à Consulta
     * @return conjunto de dados da Consulta
     */

    public String toString(){
        String info;
        info = "Numero utente: " + numeroUtente;
        info += " Numero medico: " + numeroMedico;
        info += " Data: " + data;
        return info;
    }
    
}