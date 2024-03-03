//package clean.code.design6.step04;
//
//public class PercentDiscountPolicy implements DiscountPolicy {
//    private double discountPercent;
//
//    public PercentDiscountPolicy(double discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//
//    @Override
//    public Money calculateDiscountAmount(Screening screening, Money fee, List<DiscountCondition> conditions) {
//        for (DiscountCondition condition : conditions) {
//            if (condition.isSatisfiedBy(screening)) {
//                return fee.times(discountPercent);
//            }
//        }
//        return Money.ZERO;
//    }
