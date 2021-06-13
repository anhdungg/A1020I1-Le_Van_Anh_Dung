package vn.mailbox.service;

import vn.mailbox.model.Mailbox;

import java.util.List;

public interface MailboxService {
    List<Mailbox> findAll();
    void save(Mailbox mailbox);
}
