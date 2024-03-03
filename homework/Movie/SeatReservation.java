//package homework.Movie;
//
//import java.util.Random;
//
//public class SeatReservation {
//    private ReservationManager manager;
//
//    public SeatReservation(ReservationManager manager) {
//        this.manager = manager;
//    }
//// 예약번호는 8자리의 숫자로 구성되며, 중복되지 않아야 합니다.
//    //Set을 이용하면 중복을 피할 수 있습니다.
//    // private Set<Integer> reservationNumbers = new HashSet<>();
//    public boolean reserveSeat(int row, int col) {
//        if (manager.isSeatAvailable(row, col)) {
//            String reservationNumber = generateReservationNumber();
//            manager.addReservationNumber(reservationNumber, row, col);
//            if (manager.isSeatReserved(row, col)) { // 좌석이 실제로 예약된 경우에만 예약 번호 출력
//                System.out.println("당신의 예약번호는 " + reservationNumber + " 입니다.");
//                return true;
//            }
//        } else {
//            System.out.println("이미 예약된 좌석입니다.");
//        }
//        return false;
//    }
//    private String generateReservationNumber() {
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            sb.append(random.nextInt(10)); // 0-9 사이의 숫자를 추가
//        }
//        return sb.toString();
//    }
//}