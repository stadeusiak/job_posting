package spring.sta.posting;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/postings")
public class PostingController {

    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping
    public List<Posting> getAll(){
        return postingService.getAll();
    }

    @GetMapping("/{id}")
    public Posting getById(@PathVariable Long id) {
        return postingService.getById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Posting add(@Valid @RequestBody Posting posting) {
        return postingService.add(posting);
    }

    @PutMapping("/{id}")
    public Posting update(@PathVariable Long id,@Valid @RequestBody Posting posting) {
        return postingService.upDate(id, posting).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
         postingService.deleteById(id);
    }
}
