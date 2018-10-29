package com.springcat.demo.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sitecontroller")
public class SiteController {

    @GetMapping
    String renderSite(@RequestParam(value="site",required = false) String siteParam){
        if(siteIsSupperted(siteParam)){
        return siteParam;}
        return "default";
    }

    private boolean siteIsSupperted(String siteParam) {
        return "site0".equals(siteParam)||"site1".equals(siteParam);
    }

}
