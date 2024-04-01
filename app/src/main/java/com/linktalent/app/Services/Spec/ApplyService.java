package com.linktalent.app.Services.Spec;

import com.linktalent.app.Model.Dto.Apply.ApplyDtoRequest;
import com.linktalent.app.Model.Dto.Apply.ApplyDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ApplyService extends G_Service<ApplyDtoRequest, ApplyDtoResponse, EmbeddedApply> {
    Page<ApplyDtoResponse> getUserApplication(UUID Id, Pageable pageable);
}
