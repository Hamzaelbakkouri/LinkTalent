package com.linktalent.app.Services.Implementation;

import com.linktalent.app.Exeptions.ResourceNotFoundException;
import com.linktalent.app.Model.Dto.Media.MediaDtoRequest;
import com.linktalent.app.Model.Dto.Media.MediaDtoResponse;
import com.linktalent.app.Model.Entity.Media;
import com.linktalent.app.Model.Entity.Post;
import com.linktalent.app.Model.Entity.Sport;
import com.linktalent.app.Repository.MediaRepository;
import com.linktalent.app.Repository.PostRepository;
import com.linktalent.app.Repository.SportRepository;
import com.linktalent.app.Services.Spec.MediaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;
    private final SportRepository sportRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<MediaDtoResponse> getAll(Pageable pageable) {
        Page<Media> mediaPage = mediaRepository.findAll(pageable);
        return mediaPage.map(media -> modelMapper.map(media, MediaDtoResponse.class));
    }

    @Override
    public Optional<MediaDtoResponse> create(MediaDtoRequest request) {
        Optional<Post> post = this.postRepository.findById(request.getPost());
        Optional<Sport> sport = this.sportRepository.findById(request.getSport());
        if (post.isPresent() && sport.isPresent()) {
            Media media = modelMapper.map(request, Media.class);
            media.setPost(post.get());
            media.setSport(sport.get());
            mediaRepository.save(media);
            return Optional.of(modelMapper.map(media, MediaDtoResponse.class));
        }
        throw new ResourceNotFoundException("post or sport not Found");
    }

    @Override
    public Optional<MediaDtoResponse> update(MediaDtoRequest request) {
        Optional<Media> mediaToUpdate = mediaRepository.findById(request.getId());
        Optional<Post> post = this.postRepository.findById(request.getPost());
        Optional<Sport> sport = this.sportRepository.findById(request.getSport());
        if (mediaToUpdate.isPresent() && post.isPresent() && sport.isPresent()) {
            Media media = mediaToUpdate.get();
            media.setId(request.getId());
            media.setUrl(request.getUrl());
            media.setDescription(request.getDescription());
            media.setType(request.getType());
            media.setPost(post.get());
            media.setSport(sport.get());
            mediaRepository.save(media);
            return Optional.of(modelMapper.map(media, MediaDtoResponse.class));
        }
        throw new ResourceNotFoundException("media or post or sport not Found");
    }

    @Override
    public Optional<MediaDtoResponse> getById(Integer id) {
        Optional<Media> media = mediaRepository.findById(id);
        return media.map(value -> modelMapper.map(value, MediaDtoResponse.class));
    }

    @Override
    public Boolean delete(MediaDtoRequest request) {
        if (mediaRepository.existsById(request.getId())) {
            mediaRepository.deleteById(request.getId());
            return true;
        }
        return false;
    }
}
