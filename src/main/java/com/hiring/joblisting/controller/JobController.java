package com.hiring.joblisting.controller;

import com.hiring.joblisting.respository.PostRepo;
import com.hiring.joblisting.model.Post;
import com.hiring.joblisting.respository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class JobController
{
    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo searchRepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPost()
    {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return searchRepo.findByText(text);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}
