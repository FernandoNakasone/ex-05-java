import java.text.DecimalFormat;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    public static final int N = 10;
    public static int index = 0;
    static DecimalFormat fM = new DecimalFormat("R$0.00");

    private Bilhete[] bilhete = new Bilhete[N];

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
                    if(index == 0){
                        showMessageDialog(null,"Nenhum usuario cadastrado");
                        break;
                    }
                    MenuUsuario();
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
                    listarBilhetes();
                    break;

                case 3:
                    removerBilhete();
                    break;
            }

        }while (opcao != 4);
    }

    private void emitirBilhete(){
        do{
            String nome = showInputDialog("Informe o nome do usuario:");
            long cpf = parseLong(showInputDialog("Informe o cpf do usuario"));
            String perfil = showInputDialog("Informe o perfil do usuario (Estudante, Professor ou Comum):");

            bilhete[index] = new Bilhete(new Usuario(nome, cpf, perfil));
            index++;
            break;
        }while (index <= N);
    }

    private void listarBilhetes(){
        String output = "";
        for (int i=0; i<index; i++){
            output += (i+1) + "º Número: " + bilhete[i].numero + "\n";
            output += "Nome: " + bilhete[i].usuario.nome  + "\n";
            output += "Perfil: " + bilhete[i].usuario.perfil  + "\n";
            output += "Saldo: " + fM.format(bilhete[i].saldo)+ "\n";
            output += "--------------------------------------------------\n";
        }
        showMessageDialog(null, output);
    }

    private void removerBilhete(){
        showMessageDialog(null,"Digite o número do bilhete para ser deletado");
    }

    private void MenuUsuario(){
        int opcao = 0,indice = 0,cpf;
        String menu = "Selecione uma opção: \n 1 - Consultar Saldo \n" +
                " 2 - Carregar saldo \n 3 - Simular catraca \n 4 - Voltar para menu principal ";

        cpf = parseInt(showInputDialog("Informe o cpf do usuario"));
        for(int i=0;i<index;i++){
            if(cpf == bilhete[i].usuario.cpf){
                indice = i;
                break;
            } else {
                indice = -1;
            }
            System.out.println(indice);
        }
        if(indice == -1){
            showMessageDialog(null, "Usuario não encontrado");
            opcao = 4;
        }

        while (opcao != 4) {
            opcao = parseInt(showInputDialog(menu));
            while (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
                opcao = parseInt(showInputDialog(menu));
            }

            switch (opcao){
                case 1:
                    consultarSaldo(indice);
                    break;

                case 2:
                    carregarSaldo(indice);
                    break;

                case 3:
                    simularCatraca(indice);
                    break;
            }

        };
    }

    private void consultarSaldo(int indice){
        showMessageDialog(null,"Saldo Disponivel:" + fM.format(bilhete[indice].consultarSaldo()));
    }

    private void carregarSaldo(int indice){
        double valorRecarga = parseDouble(showInputDialog("Informe o valor da recarga:"));
        bilhete[indice].carregarBilhete(valorRecarga);
    }

    private void simularCatraca(int indice){
        showMessageDialog(null, bilhete[indice].passarCatraca());
    }

}
