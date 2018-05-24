package centromedicopoo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public int getNumeroUtente(){
        return numeroUtente;
    }

    public int getNumeroMedico(){
        return numeroMedico;
    }

    public double getCustoConsulta() {
        return custoConsulta;
    }

    public void setNumeroUtente(int numeroUtente){
        this.numeroUtente = numeroUtente;
    }

    public void setNumeroMedico(int numeroMedico){
        this.numeroMedico = numeroMedico;
    }

    public void setCustoConsulta(double custoConsulta) {
        this.custoConsulta = custoConsulta;
    }

    //metodo que devolve a data de cada consulta
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

    public void setDataConsulta(String data){
        this.data = data;
    } // adicionar uma data à consulta

    /* O método seguinte recebe uma data (dd/mm/aaaa) em formato de string
     * e devolve no tipo de dado SimpleDateFormat que corresponde a uma data */
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
    
    //parsing do input string para data
    public static Date getDate(String date) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        return df.parse(date);
    }
    
    //diferença entre os dias introduzidos
    public long daysBetween(Date one, Date two){
        long difference = ( one.getTime() - two.getTime() ) / 86400000;
        return Math.abs(difference);
    }
    
    //metodo toString
    public String toString(){
        String info;
        info = "Numero utente: " + numeroUtente;
        info += " Numero medico: " + numeroMedico;
        info += " Data: " + data;
        return info;
    }
    
}