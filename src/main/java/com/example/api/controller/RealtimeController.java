package com.example.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.api.util.Constant.ROOT_PATH;

/**
 * The Controller for WebSocket
 *
 * This controller works for handle web for realtime message collect.
 */
@Controller
public class RealtimeController {
    /**
     * GET  /  -> show the index page.
     */
    @GetMapping(ROOT_PATH)
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
