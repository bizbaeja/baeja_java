//package clean.code.design6.step04;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Customer {
//    private String name;
//    private String id;
//    private static final AtomicInteger generationId = new AtomicInteger(1);
//
//    private Customer(String name) {
//        this.id = getNextId();
//        this.name = name;
//    }
//
//    private static String getNextId() {
//        return String.valueOf(generationId.getAndIncrement());
//    }
//
//    public static Customer createCustomer(String name) {
//        if (name == null || name.trim().isEmpty()) {
//            throw new IllegalArgumentException("Customer name cannot be null or empty");
//        }
//        return new Customer(name);
//    }
//
//    public Reservation reserve(Screening screening, int audienceCount) {
//        if (screening == null || audienceCount <= 0) {
//            throw new IllegalArgumentException("Invalid screening or audience count");
//        }
//        Money fee = screening.calculateFee(audienceCount);
//        return new Reservation(this, screening, fee, audienceCount);
//    }
//
//}
