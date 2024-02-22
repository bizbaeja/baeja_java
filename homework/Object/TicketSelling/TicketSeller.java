package homework.Object.TicketSelling;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
    public void selloTo(Audience audience){
//        if(audience.getBag().hasInvitation()){
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }
//    }
//    -->
        // TicketSeller가 TicketOffice에 직접 접근하는 것을 막기 위해
        // TicketSeller 에서 getTicketOffice() 메서드를 통해 TicketOffice에 접근하도록 수정
        // Audience의 가방에서 직접 접근하는 것을 막기 위해
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
