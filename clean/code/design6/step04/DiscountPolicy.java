package clean.code.design6.step04;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening, Money fee, List<DiscountCondition> conditions);
}