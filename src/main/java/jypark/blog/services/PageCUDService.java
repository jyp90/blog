package jypark.blog.services;

import jypark.blog.controllers.common.ApiPayload;
import jypark.blog.dto.DocumentInsertRequest;
import jypark.blog.entities.Documents;
import jypark.blog.exceptions.PasswordBadRequestException;
import jypark.blog.repositories.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageCUDService {

    @Value("${insert.password}")
    private String password;

    private final PageRepository pageRepository;

    public ApiPayload<Documents> insert(DocumentInsertRequest request) {
        if(!request.getPassword().equals(password)) {
            throw new PasswordBadRequestException();
        }

        final Documents saved = pageRepository.save(request.toEntity());
        return ApiPayload.create(saved);
    }
}
