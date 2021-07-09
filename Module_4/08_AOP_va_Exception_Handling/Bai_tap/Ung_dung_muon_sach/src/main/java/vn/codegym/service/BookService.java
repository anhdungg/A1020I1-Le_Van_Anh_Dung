package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.exception.NotAvailableBookException;
import vn.codegym.exception.NotFoundCodeBookException;
import vn.codegym.model.Book;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findByName(String URLName);

    int rentBook(String nameBook) throws NotAvailableBookException;

    void returnBook(String codeBook, String nameBook) throws NotFoundCodeBookException;
}
