package me.datoucai.web.hateoas;

import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/1/28
 */
@RestController
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@RequestMapping("/hal")
public class HalController {


}
