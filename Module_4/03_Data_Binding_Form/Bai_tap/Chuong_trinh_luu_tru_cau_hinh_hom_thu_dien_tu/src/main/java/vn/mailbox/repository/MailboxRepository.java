package vn.mailbox.repository;

import vn.mailbox.model.Mailbox;

import java.util.List;

public interface MailboxRepository {
    List<Mailbox> findAll();
    void save(Mailbox mailbox);
}
