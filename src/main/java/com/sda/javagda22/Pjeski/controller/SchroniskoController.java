package com.sda.javagda22.Pjeski.controller;

import com.sda.javagda22.Pjeski.service.SchroniskoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
@Slf4j
public class SchroniskoController {


    private final SchroniskoService schroniskoService;
}
