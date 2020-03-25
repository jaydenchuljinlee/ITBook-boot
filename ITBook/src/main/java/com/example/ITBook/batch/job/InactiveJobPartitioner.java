package com.example.ITBook.batch.job;

import com.example.ITBook.common.enums.Grade;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

/*
* �޸� ������ Job Flow�� Partitioning ������� ó���� Partitioner
* */
public class InactiveJobPartitioner implements Partitioner {

    private static final String GRADE = "grade";
    private static final String INACTIVE_USER_TASK = "InactiveUserTask";

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String,ExecutionContext> map = new HashMap<>(gridSize);
        Grade[] grades = Grade.values();

        for (int i = 0, loop = grades.length; i < loop; i++) {

            ExecutionContext context = new ExecutionContext();
            context.putString(GRADE,grades[i].name());
            map.put(INACTIVE_USER_TASK+i,context);
        }


        return map;
    }
}
