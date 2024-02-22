package clean.code.design6.step04;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountPolicy> discountConditions;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, DiscountPolicy... discountPolicies) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountPolicies);
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening, fee, discountConditions));
    }

    // Getter methods...
}
