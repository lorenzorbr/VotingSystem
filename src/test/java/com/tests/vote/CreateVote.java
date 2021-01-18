package com.tests.vote;

import com.tests.demo.shared.exception.MainException;
import com.tests.demo.shared.model.Schedule;
import com.tests.demo.shared.model.User;
import com.tests.demo.shared.model.Vote;
import com.tests.demo.shared.repository.VoteRepository;
import com.tests.demo.shared.service.VoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CreateVote {

    @InjectMocks
    private VoteService service;

    @MockBean
    private VoteRepository repository;

    @Test
    public void success(){
        User user = new User(1L,"Lorenzo", "590.817.440-89");
        Schedule schedule = new Schedule(1L,"Pauta para votar algo", new Date());
        Vote vote = new Vote(1L,user, schedule, true);
        Mockito.when(repository.save(vote)).thenReturn(vote);

        assertThrows(
                MainException.class,
                () -> {
                    service.getVote(1L);
                }
        );
    }
}
