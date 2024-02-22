package clean.code.design6.step04;

public class Reservation {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        validateReservation(customer, screening, fee, audienceCount);
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    private void validateReservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        if (customer == null || screening == null || fee == null || audienceCount <= 0) {
            throw new IllegalArgumentException("Invalid reservation parameters");
        }
    }

    public void printReservationDetails() {
        System.out.println("\nReservation Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Movie: " + screening.getMovie().getTitle());
        System.out.println("Date: " + screening.getWhenScreened().format(dateFormatter));
        System.out.println("Time: " + screening.getWhenScreened().format(timeFormatter));
        System.out.println("Audience count: " + audienceCount);
        System.out.println("Total fee: " + fee);
    }

    // Getter and Setter methods...
}