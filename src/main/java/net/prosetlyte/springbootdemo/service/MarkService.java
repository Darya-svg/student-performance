package net.prosetlyte.springbootdemo.service;
import net.prosetlyte.springbootdemo.model.Mark;
import net.prosetlyte.springbootdemo.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    private final MarkRepository markRepository;
    @Autowired
    public MarkService(MarkRepository markRepository) {

        this.markRepository = markRepository;
    }

    public Mark findById(Integer idMark){

        Optional<Mark> optionalMark = markRepository.findById(idMark);
        return optionalMark.orElse(null);
    }

    public List<Mark> findAll(){

        return markRepository.findAll();
    }

    public Mark saveMark(Mark mark){

        return markRepository.save(mark);
    }

    public void deleteById(Integer idMark){

        markRepository.deleteById(idMark);
    }

    public Iterable<Mark> getListGroup() {
        return markRepository.getListGroup();
    }
}
