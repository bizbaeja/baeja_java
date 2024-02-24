package homework.Movie;

import java.util.Random;

public class SeatReservation {
    private ReservationManager manager;

    public SeatReservation(ReservationManager manager) {
        this.manager = manager;
    }

    public boolean reserveSeat(int row, int col) {
        if (manager.isSeatAvailable(row, col)) {
            manager.setSeatStatus(row, col, true);
            String reservationNumber = generateReservationNumber();
            manager.addReservationNumber(reservationNumber, row, col);
            System.out.println("당신의 예약번호는 " + reservationNumber + " 입니다.");
            return true;
        } else {
            System.out.println("이미 예약된 좌석입니다.");
            return false;
        }
    }

    private String generateReservationNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10)); // 0-9 사이의 숫자를 추가
        }
        return sb.toString();
    }
}