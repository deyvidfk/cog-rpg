package cog;

import cog.domain.StageGameManager;
import dao.DataAccess;
import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyvid.fasouza
 */
public class Menu {

    private static final int[] MENU_OPTIONS = {0, 1, 2};
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
        try {
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
                case 2:
                    // Obtem e impreme a historia do jogo
                    System.out.format(DataAccess.getGameConfig().getGameHistory());
                    // Atraso para aguardar o buffer no console;
                    Thread.sleep(500);
                    System.out.print(Ansi.Red.and(Ansi.BgYellow).format("DIGITE QUALQUER COISA PARA CONTINUAR:", ""));

                    // Aguarda até que o usuário aperte qualquer tecla do teclado para inicializa o primeiro passo.
                    console.next();
                    show();
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
