package com.example.ITBook.batch.job;

import com.example.ITBook.common.domain.User;
import com.example.ITBook.common.enums.UserStatus;
import com.example.ITBook.user.repository.UserRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
* �޸� ���� ��ġ�� Read,process,write�� �ϳ��� Task�� ó���� Tasklet
* */

@Component
public class InactiveItemTasklet implements Tasklet {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        Date nowDate = (Date) chunkContext.getStepContext().getJobParameters().get("nowDate");

        LocalDateTime now = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());

        List<User> olderUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(now.minusYears(1), UserStatus.ACTIVE);

        //processor
        olderUsers = olderUsers.stream()
                    .map(User::setInactive)
                    .collect(Collectors.toList());

        userRepository.saveAll(olderUsers);

        return RepeatStatus.FINISHED;
    }
}
