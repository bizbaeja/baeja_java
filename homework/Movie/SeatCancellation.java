//package homework.Movie;
//
//public class SeatCancellation {
//    private ReservationManager manager;
//
//    public SeatCancellation(ReservationManager manager) {
//        this.manager = manager;
//    }
//
//    public boolean cancelReservationWithNumber(String reservationNumber, int row, int col) {
//        if (manager.cancelReservationWithNumber(reservationNumber, row, col)) {
//            System.out.println("예약이 취소되었습니다.");
//            return true;
//        } else {
//            System.out.println("예약 취소에 실패했습니다.");
//            return false;
//        }
//    }
//}