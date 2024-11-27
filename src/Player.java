public class Player {
    
    private int score;

    public Player(){
        this.score = 0;
    }

    public void addPoints(int points){
        score += points;
    }

    public void removePoints(){
        score -= 1;
    }

    public int getScore() {
        return score;
    }
}
