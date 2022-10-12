package app.hook.archival.repository;

import app.hook.archival.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface MessageRepository extends CrudRepository<Message, String> {
    @Query("delete from Message m where m.receivedAt < :d")
    void deleteMessagesBeforeTimestamp(@Param("d") Date date);
}