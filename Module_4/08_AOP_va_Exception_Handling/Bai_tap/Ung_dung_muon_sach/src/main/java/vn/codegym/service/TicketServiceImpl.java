package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Ticket;
import vn.codegym.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository repository;

    @Override
    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    @Override
    public void deleteById(Ticket ticket) {
        repository.delete(ticket);
    }

    @Override
    public boolean existsByCode(String codeBook) {
        return repository.existsByCode(codeBook);
    }
}
