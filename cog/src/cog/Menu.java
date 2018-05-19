package cog;

import cog.domain.StageGameManager;

/**
 *
 * @author deyvid.fasouza
 */
public class Menu {

    static int show() {
        System.out.println("Jogar");
        System.out.println("Ajuda");
        System.out.println("Sair");
        return 0;
    }

    static void menuItemHandler(int menuOption) {

        switch (menuOption) {
            // Jogar
            case 0:
                // Sair do Jogo
                System.exit(0);
                break;
            case 1:
                // Inicaliza o jogo
                new StageGameManager().initGame();
                break;
        }
    }
}
