package cog;

import cog.domain.StageGameManager;
import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author deyvid.fasouza
 */
public class Menu {

    static final int MENU_OPCAO_SAIR_JOGO = 0;
    static final int MENU_OPCAO_JOGAR = 1;
    static final int MENU_OPCAO_HISTORIA = 2;
    private static final int[] MENU_OPTIONS = {MENU_OPCAO_JOGAR, MENU_OPCAO_HISTORIA, MENU_OPCAO_SAIR_JOGO};
    private static final Scanner console = new Scanner(in);

    public static boolean contains(final int[] array, final int key) {
        return Arrays.asList(array).contains(key);
    }

    static int show() {
        int opcao = 0;
        do {
            System.out.println("================== Menu ==================");
            System.out.println("1 - Jogar ");
            System.out.println("2 - História do Jogo ");
            System.out.println("0 - Sair");
            System.out.println("=========================================");
            System.out.print("Escolha uma das opções:");
            opcao = console.nextInt();
            System.out.println();
        } while (contains(MENU_OPTIONS, opcao));
        return opcao;
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
