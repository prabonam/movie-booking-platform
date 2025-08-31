package com.xyz.theatre.service;

 
import com.xyz.theatre.dto.TheatreDTO;
import com.xyz.theatre.entity.Theatre;
import com.xyz.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public List<TheatreDTO> getAllTheatres() {
        return theatreRepository.findAll()
                .stream()
                .map(t -> new TheatreDTO(t.getId(), t.getName(), t.getLocation()))
                .collect(Collectors.toList());
    }

    public TheatreDTO createTheatre(TheatreDTO dto) {
        Theatre theatre = Theatre.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .build();
        Theatre saved = theatreRepository.save(theatre);
        return new TheatreDTO(saved.getId(), saved.getName(), saved.getLocation());
    }
}
