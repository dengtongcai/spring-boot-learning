package me.datoucai.web.hateoas;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author cc
 * @date 2019/1/28
 */
@RestController
@ExposesResourceFor(List.class)
@RequestMapping("/lists")
public class LinkController {

    private EntityLinks entityLinks;

    public LinkController(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @GetMapping(value = "/{id}")
    public Link self(@PathVariable Integer id) {
        Link link = linkTo(LinkController.class).slash(id).withSelfRel();
        return link;
    }

    @GetMapping(value = "/items")
    public Link items() {
        return linkTo(methodOn(LinkController.class).items()).withRel("items");
    }

    @GetMapping("/list")
    public Link list() {
        LinkBuilder linkBuilder = entityLinks.linkForSingleResource(List.class, 9);
        return linkBuilder.withSelfRel();
    }
}
