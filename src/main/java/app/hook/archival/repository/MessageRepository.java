package app.hook.archival.repository;

import app.hook.archival.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}