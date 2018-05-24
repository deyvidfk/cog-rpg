package cog;

import cog.models.AppConfigModel;
import dao.DataAccess;

public class Start {

    //Inicaliza a aplicação;
    public static void main(String[] args) {
        AppConfigModel appConfig = DataAccess.getGameConfig();
        //Introdução do Jogo
        System.out.format(appConfig.getGameName());
        System.out.format("Versão: " + appConfig.getGameVersion() + "%n");

        // Chama o menu e rotorna a opção escolhida;
        int menuOption = Menu.show();
        // Chama aação da opção selecionada no menu;
        Menu.menuItemHandler(menuOption);
    }
}
