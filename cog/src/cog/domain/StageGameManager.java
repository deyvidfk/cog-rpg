package cog.domain;

import cog.Ansi;
import cog.models.AppConfigModel;
import cog.models.QuestionModel;
import dao.DataAccess;
import static java.lang.System.in;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deyvid.fasouza
 */
// Gerenciar as vases do jogo
public class StageGameManager {

    private static final Scanner console = new Scanner(in);
    private final static List<QuestionModel> questionsSource = DataAccess.getQuestions();
    private final AppConfigModel appConfig;
    private final HealthPointManager healthPointManager;
    private final int MAXIMUM_STEPS;
    private int currentStep;

    private QuestionModel getQuestion(int index) {
        return questionsSource.get(index);
    }

    public StageGameManager() {
        this.currentStep = 0;
        healthPointManager = new HealthPointManager();
        MAXIMUM_STEPS = questionsSource.size() - 1;
        appConfig = DataAccess.getGameConfig();
    }

    // Inicializa o jogo
    public void initGame() {
        // Chama o primeiro desafio;
        getNextStep();
    }

    private void getNextStep() {
        try {
            // Obtem o desafio de acordo com o passo atual;
            QuestionModel challenge = getQuestion(currentStep);
            System.out.format(challenge.getNarrative() + "%n");
            System.out.format(challenge.getText() + "%n");
            // Faz a listagem de opções de resposta
            for (int i = 0; i < challenge.getResolutionOption().size(); i++) {
                System.out.format("%d - %s %n", challenge.getResolutionOption().get(i).getId(), challenge.getResolutionOption().get(i).getText());
            }
            // Atraso para aguardar o buffer no console;
            Thread.sleep(500);

            System.out.print(Ansi.BgBlue.and(Ansi.BgYellow).format("DIGITE SUA RESPOSTA:", ""));
            String respose = console.next();

            // valida o valor informado pelo usuario a partir do reclado;
            int value = validateInput(respose);

            boolean isCorrect = checkResponse(challenge, value);

            // se acertou matem o hp e incrementa 1 ponto na nota
            if (isCorrect) {
                // Ganha ponto
                healthPointManager.earnPoint();
                System.out.println(Ansi.BgGreen.and(Ansi.BgGreen).format("É isso aí! Prossiga assim.."));

            } else {
                // adiciona 1 ponto a nota
                healthPointManager.decreaseHealth();
                System.out.println(Ansi.BgRed.and(Ansi.BgRed).format("Puxa.. você errou. Tente estudar mais um pouco. Vamos continuar."));
                //up down = decrementa 1 vida
            }

            currentStep++;
            // chama o proximo desafio.
            if (currentStep < MAXIMUM_STEPS && healthPointManager.isAlive()) {
                getNextStep();
            } else {
                if (!healthPointManager.isAlive()) {
                    AppConfigModel.ResourceMessages message = appConfig.getResourceMessages()[0];
                    System.out.format("%n" + message.getText() + "%n");
                } else if (healthPointManager.isApproved()) {
                    AppConfigModel.ResourceMessages message = appConfig.getResourceMessages()[1];
                    System.out.format("%n" + message.getText() + "%n");
                } else {
                    AppConfigModel.ResourceMessages message = appConfig.getResourceMessages()[0];
                    System.out.format("%n" + message.getText() + "%n");
                    System.exit(0);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(StageGameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkResponse(QuestionModel question, int response) {
        return question.getResolutionId() == response;
    }

    // valida a entrada do usuario de acordo com os valores permitidos
    private int validateInput(String input) {
        int[] allowedValues = new int[]{1, 2, 3, 4};
        // usar regex para validar a entrada

        //parseInput
        int value = Integer.parseInt(input);

        return value;
    }
}
