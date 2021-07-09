package vn.codegym.service;

import vn.codegym.model.Ticket;

public interface TicketService {
    void save(Ticket ticket);

    void deleteById(Ticket ticket);

    boolean existsByCode(String codeBook);
}
