package entity;

public class CreditScore {
    private int id;
    private int score;
    private String rating;


    public CreditScore(int id, int score) {
        this.id = id;
        this.score = score;
        this.rating = decideRating(score);
    }



    private String decideRating(int score) {

        if (score < 300 || score > 900) {
            throw new IllegalArgumentException("Credit score must be between 300 and 900");
        }
        if (score >= 750) {
            return "Excellent";
        } else if (score >= 650) {
            return "Good";
        } else {
            return "Poor";
        }


    }

    public CreditScore() {
    }

    @Override
    public String toString() {
        return "CreditScore{" +
                "id=" + id +
                ", score=" + score +
                ", rating='" + rating + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
