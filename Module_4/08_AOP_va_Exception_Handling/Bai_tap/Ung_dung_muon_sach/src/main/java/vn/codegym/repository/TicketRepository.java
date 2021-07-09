package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Book;
import vn.codegym.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    boolean existsByCode(String codeBook);

    Ticket findByCodeAndBook(String codeBook, Book book);
}
