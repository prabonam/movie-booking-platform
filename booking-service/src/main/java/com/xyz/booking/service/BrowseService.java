package com.xyz.booking.service;

 
import com.xyz.booking.dto.BrowseRequest;
import com.xyz.booking.dto.BrowseResponse;
import com.xyz.booking.entity.Show;
import com.xyz.booking.repository.ShowRepository;
import com.xyz.booking.repository.ShowSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrowseService {

    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;

    public BrowseResponse browse(BrowseRequest req) {
        LocalDate date = req.date();
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);

        List<Show> shows = showRepository.findByMovieTitleIgnoreCaseAndShowTimeBetween(req.movieTitle(), start, end);

        var grouped = shows.stream().collect(Collectors.groupingBy(Show::getTheatreName));

        var theatres = grouped.entrySet().stream().map(e -> {
            var slots = e.getValue().stream()
                    .sorted((a,b)->a.getShowTime().compareTo(b.getShowTime()))
                    .map(s -> new BrowseResponse.ShowSlot(
                            s.getId(),
                            s.getShowTime().toLocalTime().toString(),
                            showSeatRepository.findByShowAndBooked(s, false).size(),
                            s.getPriceCents()
                    )).toList();
            return new BrowseResponse.TheatreShows(e.getKey(), slots);
        }).toList();

        return new BrowseResponse(req.city(), req.movieTitle(), req.date().toString(), theatres);
    }
}
