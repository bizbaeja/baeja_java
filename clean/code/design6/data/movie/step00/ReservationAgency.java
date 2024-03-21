package clean.code.design6.data.movie.step00;

import clean.code.design6.money.Money;

public class ReservationAgency {
    //reserve 메소드는 Screening, Customer, 예약자수를 받아서 예약 객체를 생성하여 반환한다
    static public Reservation reserve(Screening screening, Customer customer,
                                      int audienceCount) {
        //영화 정보 얻기
        Movie movie = screening.getMovie();

        //해당 영화가 할인 가능한지 여부 확인
        boolean discountable = false;
        for(DiscountCondition condition : movie.getDiscountConditions()) {
            //할인 조건이 기간인지 확인 한다
            if (condition.getType() == DiscountConditionType.PERIOD) {
                //screening.getWhenScreened().getDayOfWeek() : 상영일의 요일
                //condition.getDayOfWeek() : 할인 조건의 요일
                //screening.getWhenScreened().toLocalTime() : 상영시작시간
                //condition.getStartTime() : 할인 조건의 시작시간
                // 시작 시간 이후 확인 :
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                //할인이 순번에 맞는지 확인 한다
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        } //for (DiscountCondition ...

        Money fee;
        if (discountable) {
            //할인 가능하면
            Money discountAmount = Money.ZERO;
            //할인 정책에 따른 요금 계산
            switch(movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    //금액으로 할인 금액 계산
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    //퍼센트로 할인 금액 계산
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }
            //영화비에서 할인 금액만큼 빼고 예약자수 만큼 곱하여 요금계산 한다
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            //영화비를 예약자수 만큼 곱하여 요금계산 한다
            fee = movie.getFee().times(audienceCount);
        }
        //예약 객체를 생성한다
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
