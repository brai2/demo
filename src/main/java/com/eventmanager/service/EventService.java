package com.eventmanager.service;

import com.eventmanager.model.Event;
import com.eventmanager.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        if (event.getStartTime() != null && event.getEndTime() != null
                && event.getEndTime().isBefore(event.getStartTime())) {
            throw new IllegalArgumentException("Thoi gian ket thuc phai sau thoi gian bat dau");
        }
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
