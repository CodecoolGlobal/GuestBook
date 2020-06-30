package service;

import dao.DaoException;
import dao.MessageDao;
import dao.MessageDaoImpl;
import model.Message;
import view.View;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    private List<Message> messages;
    private View view;

    public MessageService() {
        messageDao = new MessageDaoImpl();
        view = new View();
    }

    public List<Message> getMessages() {
        try {
            messages = messageDao.getMessages();
            view.printSuccess("Messages have been successfully retrieved.");
        } catch (DaoException e) {
            view.printError(e.getMessage());
        }
        return messages;
    }

    public void createMessage(String NAME, String MESSAGE) {
        Message message;
        OffsetDateTime DATE = OffsetDateTime.now(ZoneOffset.UTC);

        message = new Message(DATE, NAME, MESSAGE);

        try {
            messageDao.create(message);
            view.printSuccess("Message has been successfully created.");
        } catch (DaoException e) {
            view.printError(e.getMessage());
        }
    }
}
