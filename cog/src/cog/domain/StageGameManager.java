package cog.domain;

import cog.models.AppConfigModel;
import cog.models.QuestionModel;
import dao.DataAccess;
import static java.lang.System.in;
import java.util.List;
import java.util.Scanner;

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
        //Introdução do Jogo
        System.out.format(appConfig.getGameName() + "%n");
        System.out.format("Versão: " + appConfig.getGameVersion() + "%n");
        System.out.format(appConfig.getGameHistory() + "%n");
        System.out.println("DIGITE QUALQUER COISA PARA CONTINUAR: ");
        // Aguarda até que o usuário aperte qualquer tecla do teclado para inicializa o primeiro passo.
        console.next();
        // Chama o primeiro desafio;
        getNextStep();
    }

    private void getNextStep() {
        // Obtem o desafio de acordo com o passo atual;
        QuestionModel challenge = getQuestion(currentStep);
        System.out.format(challenge.getNarrative());
        System.out.println("");
        System.out.println("");
        System.out.format(challenge.getText());
        System.out.println("");
        System.out.println("");
        // Faz a listagem de opções de resposta
        for (int i = 0; i < challenge.getResolutionOption().size(); i++) {
            System.out.format("%d - %s %n", challenge.getResolutionOption().get(i).getId(), challenge.getResolutionOption().get(i).getText());
        }
        System.out.println("");
        System.out.println("DIGITE SUA RESPOTA: ");
        String respose = console.next();

        // valida o valor informado pelo usuario a partir do reclado;
        int value = validateInput(respose);

        boolean isCorrect = checkResponse(challenge, value);

        // se acertou matem o hp e incrementa 1 ponto na nota
        if (isCorrect) {
            // Ganha ponto
            healthPointManager.earnPoint();
            System.out.println("Você é phoda! Prossiga assim, ceRRRto. ");

        } else {
            // adiciona 1 ponto a nota
            healthPointManager.decreaseHealth();
            System.out.println("Puxa... tente estudar mais um pouco. Vamos continuar.");
            //up down = decrementa 1 vida 
        }

        currentStep++;
        // chama o proximo desafio.
        if (currentStep < MAXIMUM_STEPS && healthPointManager.isAlive()) {
            getNextStep();
        } else {
            if (!healthPointManager.isAlive()) {
                System.out.println("GAME OVER!");
            } else if (healthPointManager.isApproved()) {
                System.out.println("GANHOU VIAAAAAAAAAAAAAAADO!");
            } else {
                System.out.println("GAME OVER!");
                System.exit(0);
            }
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
