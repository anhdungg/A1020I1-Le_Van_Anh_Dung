package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.exception.NotAvailableBookException;
import vn.codegym.exception.NotFoundCodeBookException;
import vn.codegym.model.Book;
import vn.codegym.model.Ticket;
import vn.codegym.repository.BookRepository;
import vn.codegym.repository.TicketRepository;

import java.util.Random;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findByName(String URLName) {
        return bookRepository.findByURLName(URLName);
    }

    @Override
    public int rentBook(String nameBook) throws NotAvailableBookException {
        Book book = bookRepository.findByURLName(nameBook);
        if (book.getUnit()<=0){
            throw new NotAvailableBookException();
        }
        Random random = new Random();
        int number = random.nextInt(99999)+10000;

        Ticket ticket = new Ticket(number+"", book);

        this.ticketRepository.save(ticket);

        book.setUnit(book.getUnit()-1);

        this.bookRepository.save(book);
        return number;
    }

    @Override
    public void returnBook(String codeBook, String nameBook) throws NotFoundCodeBookException{
        Book book = bookRepository.findByURLName(nameBook);

        if (this.ticketRepository.existsByCode(codeBook)){
            this.ticketRepository.delete(this.ticketRepository.findByCodeAndBook(codeBook, book));
            book.setUnit(book.getUnit()+1);
            this.bookRepository.save(book);
        }else {
            throw new NotFoundCodeBookException();
        }

    }
}
