package dao;

import model.Message;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {


    public void create(Message message) throws DaoException {
        String query = "INSERT INTO messages "
                + "(date, name, message) "
                + "VALUES(?, ?, ?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDate(1, Date.valueOf(message.getDATE()));
            preparedStatement.setString(2, message.getNAME());
            preparedStatement.setString(3, message.getMESSAGE());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Failed to create a message.\n" + e);
        }
    }

    public List<Message> getMessages() throws DaoException {
        return null;
        List<Message> messages;
        String query = "SELECT date, name, message FROM messages";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            messages = getMessagesFrom(preparedStatement);

        } catch (SQLException e) {
            throw new DaoException("Failed to receive messages.\n" + e);
        }
        return messages;
    }
    private List<Message> getMessagesFrom(PreparedStatement preparedStatement) throws DaoException {

        Message message;
        List<Message> messages = new ArrayList<>();

        LocalDate DATE;
        String NAME;
        String MESSAGE;

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                DATE = resultSet.getDate("date").toLocalDate();
                NAME = resultSet.getString("name");
                MESSAGE = resultSet.getString("message");

                message = new Message(DATE, NAME, MESSAGE);
                messages.add(message);
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to populate list of messages.\n" + e);
        }
        return messages;
    }
}
