package cog;

public class Start {

    //Inicaliza a aplicação;
    public static void main(String[] args) {
        // Chama o menu e rotorna a opção escolhida;
        int menuOption = Menu.show();
        // Chama aação da opção selecionada no menu;
        Menu.menuItemHandler(menuOption);
    }
}
