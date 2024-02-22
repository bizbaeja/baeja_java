package clean.code.design6.step04;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public boolean isSatisfied(DiscountPolicy condition) {
        return condition.isSatisfiedBy(this);
    }

    // Getter methods...
}