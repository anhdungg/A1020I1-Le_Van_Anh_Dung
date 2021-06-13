package vn.mailbox.repository;

import org.springframework.stereotype.Repository;
import vn.mailbox.model.Mailbox;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepositoryImpl implements MailboxRepository {
    private static List<Mailbox> list = new ArrayList<>();

    static {
        list.add(new Mailbox("English", "5", true, "Thor\nKing Asgard"));
        list.add(new Mailbox("Vietnamese", "10", false, "Thor\nKing Asgard"));
        list.add(new Mailbox("English", "15", true, "Thor\nKing Asgard"));
    }
    @Override
    public List<Mailbox> findAll() {
        return list;
    }

    @Override
    public void save(Mailbox mailbox) {
        list.add(mailbox);
    }
}
