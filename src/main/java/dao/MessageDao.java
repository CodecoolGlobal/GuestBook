package dao;

import model.Message;

import java.util.List;

public interface MessageDao {

    void create(Message message) throws DaoException;

    List<Message> getMessages() throws DaoException;

}
