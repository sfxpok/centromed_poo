package centromedicopoo;

import java.util.Scanner;
import java.io.*;

public class Login {

    public static Scanner scan = new Scanner(System.in);
    public static String ficheiro = "Utilizador.txt";

    /**
     * Menu de login/registo
     * @throws IOException
     */

    public static void menuRegisto() throws IOException {

        // Apresenta o menu para Login & Registo
        System.out.println(" ");
        System.out.println("1 - Login");
        System.out.println("2 - Registo");
        System.out.print("Opcao: ");
        int opcao = scan.nextInt();

        if(opcao == 1){
            System.out.println(" ");
            Login(ficheiro);
        }
        else if(opcao == 2){
            System.out.println(" ");
            Registo(ficheiro);
        }
        else{
            System.out.println("ERRO: Não introduziu uma opção válida!");
            System.out.println(" ");
            menuRegisto();
        }
    }

    /**
     * Realiza o login de um dado utilizador. O input é verificado com um ficheiro de
     * texto previamente escrito
     * @param ficheiro ficheiro de texto com os respetivos utilizadores e passwords
     * @throws IOException
     */

    public static void Login(String ficheiro) throws IOException{

        // Stream de leitura
        FileReader inStream = new FileReader("Utilizador.txt");
        BufferedReader bR = new BufferedReader(inStream);
        Scanner in = new Scanner(bR);

        // Define duas strings
        System.out.println("Introduza um Username");
        String user = scan.next();
        System.out.println("Introduza uma password");
        String pass = scan.next();

        // Concatena essas duas strings
        String userPass = user + pass;

        // Cria uma string auxiliar que guarda o valor do ficheiro
        String aux = in.next();

        // Fecha o Scanner, fecha a stream;
        in.close();
        bR.close();

        // Efetua as verificações
        if (aux.contains(userPass)){
            System.out.print("Login efetuado com sucesso! \n");
        }

        else{
            System.out.print("Utilizador ou Password errada! \n");
            menuRegisto();
        }

    }

    /**
     * Efetua o registo de um novo utilizador. A informação inserida é guardad num ficheiro de texto
     * com o nome "utilizador.txt".
     * @param ficheiro
     * @throws IOException
     */

    public static void Registo(String ficheiro) throws IOException{

        // Stream de escrita
        FileWriter outStream = new FileWriter(ficheiro, true);
        BufferedWriter bW = new BufferedWriter(outStream);
        PrintWriter out = new PrintWriter(bW);

        System.out.println("Introduza um Username");
        String user = scan.next();
        System.out.println("Introduza uma password");
        String pass = scan.next();

        // Concatena essas duas strings
        String userPass = user + pass;

        //out.print(userPass + "\n");
        out.print(userPass);

        // Fecha & Guarda o ficheiro, fecha a stream;
        out.close();
        bW.close();

        menuRegisto();
    }

}
