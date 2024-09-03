package com.tg1.tg1.Controllers;

import com.tg1.tg1.Models.Schedule;
import com.tg1.tg1.Services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public String listSchedules(Model model) {
        model.addAttribute("schedules", scheduleService.getAllSchedules());
        return "schedule/schedule-list";
    }

    @GetMapping("/new")
    public String createScheduleForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "schedule/schedule-form";
    }

    @PostMapping
    public String saveSchedule(@ModelAttribute Schedule schedule) {
        scheduleService.saveSchedule(schedule);
        return "redirect:/schedules";
    }

    @GetMapping("/{id}")
    public String viewSchedule(@PathVariable Long id, Model model) {
        model.addAttribute("schedule", scheduleService.getScheduleById(id));
        return "schedule/schedule-detail";
    }

    @GetMapping("/{id}/delete")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
}
