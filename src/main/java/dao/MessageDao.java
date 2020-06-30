package dao;

import model.Message;

import java.util.List;

public interface MessageDao {

    public void create(Message message) throws DaoException;

    public List<Message> getMessages() throws DaoException;

}
