package com.example.ITBook.restApi.event;

import com.example.ITBook.common.domain.FileVO;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class FileEventHandler {

    @HandleBeforeCreate
    public void beforeUploadFile(FileVO file) {
        file.setCreatedDate();
    }
}
