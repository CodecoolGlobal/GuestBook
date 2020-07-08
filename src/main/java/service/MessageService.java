package service;

import dao.DaoException;
import dao.MessageDao;
import dao.MessageDaoImpl;
import model.Message;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    private List<Message> messages;

    public MessageService() {
        messageDao = new MessageDaoImpl();
    }

    public List<Message> getMessages() {
        try {
            messages = messageDao.getMessages();
            System.out.println("MASSAGE RETRIEVEMENT SUCESS");
        } catch (DaoException e) {
            System.out.println("MASSAGE RETRIEVEMENT FAIL");
        }
        return messages;
    }

    public void createMessage(String name, String userMessage) {
        Message message;
        OffsetDateTime date = OffsetDateTime.now(ZoneOffset.UTC);

        message = new Message(date, name, userMessage);

        try {
            messageDao.create(message);
            System.out.println("MESSAGE CREATION SUCCESS");
        } catch (DaoException e) {
            System.out.println("MESSAGE CREATION FAIL");
        }
    }
}
