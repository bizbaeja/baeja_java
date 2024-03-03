//package homework.Movie;
//
//
//public class SeatChecker {
//    private ReservationManager manager;
//
//    public SeatChecker(ReservationManager manager) {
//        this.manager = manager;
//    }
//
//    public boolean checkSeat(int row, int col) {
//        if (manager.isSeatReserved(row, col)) {
//            System.out.println("이 좌석은 이미 예약되어 있습니다.");
//            return true;
//        } else {
//            System.out.println("이 좌석은 예약되어 있지 않습니다.");
//            return false;
//        }
//    }
//}