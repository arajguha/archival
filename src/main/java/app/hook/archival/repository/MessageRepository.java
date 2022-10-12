package app.hook.archival.repository;

import app.hook.archival.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {
    @Query("select m from Message m where m.receivedAt > :d1 and m.receivedAt < :d2")
    List<Message> findMessagesWithinDateRange(@Param("d1") Date startDate, @Param("d2") Date endDate);
}