package vn.mailbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mailbox.model.Mailbox;
import vn.mailbox.repository.MailboxRepository;

import java.util.List;

@Service
public class MailboxServiceImpl implements MailboxService {
    @Autowired
    private MailboxRepository repository;

    @Override
    public List<Mailbox> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Mailbox mailbox) {
        repository.save(mailbox);
    }
}
