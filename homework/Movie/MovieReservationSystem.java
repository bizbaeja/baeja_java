//package homework.Movie;
//
//import java.util.Scanner;
//
//public class MovieReservationSystem {
//    private static SeatReservation reservation;
//    private static SeatCancellation cancellation;
//    private static SeatChecker checker;
//    private static ReservationManager manager;
//    private static Scanner scanner;
//
//    public static void main(String[] args) {
//        int rows = 10; // 좌석 행의 수
//        int cols = 10; // 좌석 열의 수
//
//        manager = new ReservationManager(rows, cols);
//
//        reservation = new SeatReservation(manager);
//        cancellation = new SeatCancellation(manager);
//        checker = new SeatChecker(manager);
//        scanner = new Scanner(System.in);
//
//
//        boolean running = true;
//        while (running) {
//            System.out.println("영화 예매 시스템");
//            System.out.println("1. 예매하기 2. 예매 취소하기 3. 예매 확인하기 4. 종료하기");
//            System.out.print("선택: ");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    reserveSeat();
//                    break;
//                case 2:
//                    cancelReservation();
//                    break;
//                case 3:
//                    checkReservation();
//                    break;
//
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("잘못된 선택입니다.");
//            }
//        }
//        scanner.close();
//    }
//
//    private static void reserveSeat() {
//        System.out.print("예매할 좌석의 행과 열을 입력하세요 (예: 3 5): ");
//        int row = scanner.nextInt();
//        int col = scanner.nextInt();
//        reservation.reserveSeat(row, col);
//    }
//
//    private static void cancelReservation() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("취소할 예약 번호를 입력하세요: ");
//        String reservationNumber = scanner.nextLine();
//
//        System.out.print("취소할 좌석의 행을 입력하세요: ");
//        int row = 0;
//        try {
//            row = Integer.parseInt(scanner.nextLine()); // 정수로 변환
//        } catch (NumberFormatException e) {
//            System.out.println("올바른 숫자 형식을 입력하세요.");
//            return;
//        }
//
//        System.out.print("취소할 좌석의 열을 입력하세요: ");
//        int col = 0;
//        try {
//            col = Integer.parseInt(scanner.nextLine()); // 정수로 변환
//        } catch (NumberFormatException e) {
//            System.out.println("올바른 숫자 형식을 입력하세요.");
//            return;
//        }
//
//        // 예약 취소 로직 실행
//        boolean cancellationSuccessful = manager.cancelReservationWithNumber(reservationNumber, row, col);
//
//        if (cancellationSuccessful) {
//            System.out.println("예약이 성공적으로 취소되었습니다.");
//        } else {
//            System.out.println("예약 취소에 실패했습니다. 올바른 예약 번호와 좌석 번호를 입력했는지 확인하세요.");
//        }
//
//    }
//
//    private static void checkReservation() {
//        System.out.print("확인할 좌석의 행과 열을 입력하세요 (예: 3 5): ");
//        int row = scanner.nextInt();
//        int col = scanner.nextInt();
//        checker.checkSeat(row, col);
//    }
//}