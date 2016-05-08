package org.metabook.server.api.book.engine.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//@RequestMapping("/api/status")
public class PingController {

	    @RequestMapping(value = "/api/ping", method = RequestMethod.GET)
	    @ResponseBody
	    public String showIndex() {
	        return "Hello world";
	    }

	}

