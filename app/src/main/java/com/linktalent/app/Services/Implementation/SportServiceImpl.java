package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Model.Dto.Sport.SportRequestDTO;
import com.linktalent.app.Model.Dto.Sport.SportResponseDTO;
import com.linktalent.app.Model.Entity.Sport;
import com.linktalent.app.Repository.SportRepository;
import com.linktalent.app.Services.Spec.SportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SportServiceImpl implements SportService {
    private final SportRepository sportRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<SportResponseDTO> getAll(Pageable pageable) {
        Page<Sport> sportPage = sportRepository.findAll(pageable);
        return sportPage.map(sport -> modelMapper.map(sport, SportResponseDTO.class));
    }

    @Override
    public Optional<SportResponseDTO> create(SportRequestDTO request) {
        Optional<Sport> sport = Optional.of(this.sportRepository.save(this.modelMapper.map(request, Sport.class)));
        return sport.map(value -> this.modelMapper.map(value, SportResponseDTO.class));
    }

    @Override
    public Optional<SportResponseDTO> update(SportRequestDTO request) {
        Optional<Sport> sportToUpdate = this.sportRepository.findById(request.getId());
        if (sportToUpdate.isPresent()) {
            request.setId(sportToUpdate.get().getId());
            Optional<Sport> sport = Optional.of(this.sportRepository.save(this.modelMapper.map(request, Sport.class)));
            return sport.map(value -> this.modelMapper.map(value, SportResponseDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<SportResponseDTO> getById(UUID uuid) {
        return Optional.of(this.modelMapper.map(this.sportRepository.findById(uuid).get(), SportResponseDTO.class));
    }

    @Override
    public Boolean delete(SportRequestDTO request) {
        if (this.sportRepository.findById(request.getId()).isPresent()) {
            this.sportRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
