package com.eventmanager.controller;

import com.eventmanager.model.Event;
import com.eventmanager.service.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String redirectToEvents() {
        return "redirect:/events";
    }

    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "events/list";
    }

    @GetMapping("/events/new")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/form";
    }

    @PostMapping("/events")
    public String createEvent(@Valid @ModelAttribute("event") Event event,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "events/form";
        }
        try {
            eventService.save(event);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("timeError", ex.getMessage());
            return "events/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Tao su kien thanh cong");
        return "redirect:/events";
    }

    @GetMapping("/events/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return eventService.findById(id)
                .map(event -> {
                    model.addAttribute("event", event);
                    return "events/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Khong tim thay su kien");
                    return "redirect:/events";
                });
    }

    @PostMapping("/events/{id}")
    public String updateEvent(@PathVariable Long id,
                              @Valid @ModelAttribute("event") Event event,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "events/form";
        }
        try {
            event.setId(id);
            eventService.save(event);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("timeError", ex.getMessage());
            return "events/form";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Cap nhat su kien thanh cong");
        return "redirect:/events";
    }

    @PostMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        eventService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Xoa su kien thanh cong");
        return "redirect:/events";
    }
}
