package com.linktalent.app.Controllers;

import com.linktalent.app.Model.Dto.Connect.ConnectDtoRequest;
import com.linktalent.app.Model.Dto.Connect.ConnectDtoResponse;
import com.linktalent.app.Model.Embedded.EmbeddedConnect;
import com.linktalent.app.Services.Spec.ConnectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/connect")
@RequiredArgsConstructor
public class ConnectController {
    private final ConnectService connectService;

    @GetMapping
    public ResponseEntity<Page<ConnectDtoResponse>> getAllConnects(Pageable pageable) {
        Page<ConnectDtoResponse> connectDtoResponses = connectService.getAll(pageable);
        return ResponseEntity.ok(connectDtoResponses);
    }

    @PostMapping
    public ResponseEntity<ConnectDtoResponse> createConnect(@RequestBody ConnectDtoRequest request) {
        Optional<ConnectDtoResponse> connectDtoResponse = connectService.create(request);
        return connectDtoResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<ConnectDtoResponse> updateConnect(@RequestBody ConnectDtoRequest request) {
        Optional<ConnectDtoResponse> connectDtoResponse = connectService.update(request);
        return connectDtoResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{personRequest}/{personToAccept}")
    public ResponseEntity<ConnectDtoResponse> getConnectById(@PathVariable("personRequest") Long personRequestId,@PathVariable("personToAccept") Long personToAcceptId) {
        EmbeddedConnect embeddedConnect = new EmbeddedConnect();
        Optional<ConnectDtoResponse> connectDtoResponse = connectService.getById(embeddedConnect);
        return connectDtoResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteConnect(@RequestBody ConnectDtoRequest request) {
        Boolean deleted = connectService.delete(request);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}