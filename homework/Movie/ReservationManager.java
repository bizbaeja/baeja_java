package homework.Movie;

import java.util.HashMap;
import java.util.Map;

public class ReservationManager {
    private boolean[][] reserve;
    private Map<String, boolean[][]> reservationNumbers;

    public ReservationManager(int rows, int cols) {
        reserve = new boolean[rows][cols];
        reservationNumbers = new HashMap<>();
    }

    public ReservationManager() {
        reservationNumbers = new HashMap<>();
    }

    private boolean isValidSeat(int row, int col) {
        return row >= 1 && row <= reserve.length && col >= 1 && col <= reserve[0].length;
    }

    protected boolean isSeatAvailable(int row, int col) {
        if (!isValidSeat(row, col)) {
            return false;
        }
        return !reserve[row - 1][col - 1];
    }

    protected void setSeatStatus(int row, int col, boolean status) {
        if (!isValidSeat(row, col)) {
            return;
        }
        reserve[row - 1][col - 1] = status;
    }

    public void addReservationNumber(String reservationNumber, int row, int col) {
        boolean[][] seats = new boolean[getRows()][getCols()];
        seats[row - 1][col - 1] = true;
        reservationNumbers.put(reservationNumber, seats);
    }

    public boolean checkReservationNumber(String reservationNumber, int row, int col) {
        if (reservationNumbers.containsKey(reservationNumber)) {
            return reservationNumbers.get(reservationNumber)[row - 1][col - 1];
        }
        return false;
    }

    public boolean cancelReservationWithNumber(String reservationNumber, int row, int col) {
        if (reservationNumbers.containsKey(reservationNumber) && checkReservationNumber(reservationNumber, row, col)) {
            reserve[row - 1][col - 1] = false;
            reservationNumbers.remove(reservationNumber);
            return true;
        } else {
            System.out.println("예약 취소 실패: 예약번호 " + reservationNumber + "와 좌석번호 " + row + "," + col + "가 일치하지 않습니다.");
            return false;
        }
    }

    protected int getRows() {
        return reserve.length;
    }

    protected int getCols() {
        return reserve[0].length;
    }

    public boolean isSeatReserved(int row, int col) {
        return false;
    }
}