package com.example.ITBook.batch.readers;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListItemReader<T> implements ItemReader<T> {
    private List<T> list;

    public ListItemReader(List<T> data) {
        this.list = new LinkedList<>(data);
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return this.list.remove(0);
    }
}
