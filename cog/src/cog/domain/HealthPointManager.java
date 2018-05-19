package cog.domain;

// Classe gerenciar pontos de vida o usuario
public class HealthPointManager {

    // HP
    private int healthPoint;
    private int nota = 0;

    public HealthPointManager() {
        // Inicializa com o HP Maximo
        healthPoint = 6;
    }

    // checa se o jogaor está vivo
    public boolean isAlive() {
        return healthPoint != 0;
    }

    public void earnPoint() {
        nota++;
    }

    public void decreaseHealth() {
        healthPoint--;
    }

    public boolean isApproved() {

        double result = (nota * 100) / 10;

        if (result > 60) {
            // APROVADO

            return true;
        } else {
            // reporvado
            return false;
        }
    }
}
