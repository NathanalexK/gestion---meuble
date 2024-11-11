package com.source.meuble.talent.test;

import com.source.meuble.talent.cv.Cv;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test save(Test test){
        return testRepository.save(test);
    }

    public List<Test> getAll(){

        return testRepository.findByEtat(0);
    }
}
