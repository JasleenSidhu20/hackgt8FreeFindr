package sample;

public class Monument {
    private int health;
    public void setHealthFromDifficulty(Difficulty difficulty) {
        if (difficulty == null) {
            throw new IllegalArgumentException("Difficulty cannot be null.");
        }
        switch (difficulty) {
        case EASY:
            this.health = 500;
            break;
        case MEDIUM:
            this.health = 400;
            break;
        default:
            // case HARD
            this.health = 300;
            break;
        }
    }
    public int getHealth() {
        return this.health;
    }
}
