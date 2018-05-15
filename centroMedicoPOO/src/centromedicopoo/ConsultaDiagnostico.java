package centromedicopoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConsultaDiagnostico {

    private int numeroUtente;
    private int numeroMedico;
    private String data;
    private boolean solicitaExame;
    private ArrayList<Utente> utentes;
    private ArrayList<Medico> medicos;

    ////////////////////////// *** Construtores *** //////////////////////////

    public ConsultaDiagnostico (int numeroUtente, int numeroMedico, String data) {
        this.numeroUtente = numeroUtente;
        this.numeroMedico = numeroMedico;
        this.data = data;
    }
    public ConsultaDiagnostico () {

    }

    ////////////////////////// *** Getters e setters *** //////////////////////////

    public int getNumeroUtente(){
        return numeroUtente;
    }

    public int getNumeroMedico(){
        return numeroMedico;
    }

    public void setNumeroUtente(int numeroUtente){
        this.numeroUtente = numeroUtente;
    }

    public void setNumeroMedico(int numeroMedico){
        this.numeroMedico = numeroMedico;
    }

    ////////////////////////////////////////////////////////////////////////////////

    public boolean solicitaExame(){
        return true;
    } // caso o médico solicite um exame

    public void addUtente(Utente utente){
        utentes.add(utente);
    } // adicionar um utente à consulta

    public void addMedico(Medico medico){
        medicos.add(medico);
    } // adicionar um médico à consulta

    public void setDataConsulta(String data){
        this.data = data;
    } // adicionar uma data à consulta

    /* O método seguinte recebe uma data (dd/mm/aaaa) em formato de string
     * e devolve no tipo de dado SimpleDateFormat que corresponde a uma data */
    public boolean verificaData(String date)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");

        /* declarar e inicializar variável testeData, esta variável vai conter
         * o valor da string convertida */

        Date testeData = null;

        // tentar fazer o parsing da string para o formato data
        try
        {
            testeData = sdf.parse(date);
        }
        // se o formato da string disponibilizada nao for equivalente ao formato declarado em SimpleDateFormat() teremos uma excepcao
        catch (ParseException e)
        {
            String mensagemErro = "A data disponiblizada está num formato inválido";
            return false;
        }

        if (!sdf.format(testeData).equals(date))
        {
            String mensagemErro = "A data disponibilizada é inválida";
            return false;
        }

        // se chegarmos até aqui nas verificações iremos assumir que o formato da data está correcta

        return true;

    }

}
