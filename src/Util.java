import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Util {
    public static final int N = 10;
    public static int index = 0;

    private Bilhete[] bilhete = new Bilhete[N];
    private Usuario[] usuario = new Usuario[N];

    public void MenuPrincipal() {
        int opcao;
        String menu = "Escolha o perfil: \n 1 - Administrador \n 2 - Usuário \n 3 - Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));
            while (opcao < 1 || opcao > 3){
                showMessageDialog(null, "Opção inválida");
                opcao = parseInt(showInputDialog(menu));
            }

            switch (opcao){
                case 1 :
                    MenuAdministrador();
                    break;
                case 2:
                    //MenuUsuario();
                    break;
            }
        } while (opcao != 3);
    }

    private void MenuAdministrador(){
        int opcao;
        String menuAdm = "Seleciona a função para ser executada: \n 1 - Emitir novo bilhete " +
                "\n 2 - Listar bilhetes cadastrados \n 3 - Remover bilhete \n 4 - Voltar para menu principal ";

        do {
            opcao = parseInt(showInputDialog(menuAdm));
            while (opcao < 0 || opcao > 4){
                showMessageDialog(null, "Opção inválida");
                opcao = parseInt(showInputDialog(menuAdm));
            }

            switch (opcao){
                case 1:
                    emitirBilhete();
                    break;

                case 2:
                  //  listarBilhetes();
                    break;

                case 3:
                //    removerBilhete();
                    break;
            }

        }while (opcao != 4);
    }

    private void emitirBilhete(){
        do {
            String nome = showInputDialog("Informe o nome do usuario:");
            Long cpf = parseLong(showInputDialog("Informe o cpf do usuario"));
            String perfil = showInputDialog("Informe o perfil do usuario:");

            usuario[index].nome = nome;
            usuario[index].cpf = cpf;
            usuario[index].perfil = perfil;
            index++;
            break;
        }while (index != N);
    }

  //  Usuario[] usuario = new Usuario(nome, cpf, perfil);

}
