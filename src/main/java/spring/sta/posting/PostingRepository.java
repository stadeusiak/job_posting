package spring.sta.posting;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class PostingRepository {

    private final Map<Long, Posting> storage = new ConcurrentHashMap<>();
    private final AtomicLong SEQ = new AtomicLong(0L);

    public Optional<Posting> findById(Long id) {
       return Optional.ofNullable(storage.get(id));
    }

    public List<Posting> findAll() {
        return List.copyOf(storage.values());
    }

    public Posting save(Posting posting) {
        if (posting.getId() == null) {
            posting.setId(SEQ.incrementAndGet());
        }
        storage.put(posting.getId(), posting);
        return posting;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}
