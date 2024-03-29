package spring.sta.posting;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostingService {

    private  final PostingRepository postingRepository;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public List<Posting> getAll() {
        return postingRepository.findAll();
    }

    public Optional<Posting> getById(Long id) {
        return  postingRepository.findById(id);
    }

    public Posting add(Posting posting) {
        return postingRepository.save(posting);
    }
    public Optional<Posting> upDate(Long id, Posting newPosting) {
        return postingRepository.findById(id)
                .map(posting -> {
                    newPosting.setId(posting.getId());
                    return postingRepository.save(newPosting);
                });
    }

    public void deleteById(Long id) {
        postingRepository.deleteById(id);
    }
}
