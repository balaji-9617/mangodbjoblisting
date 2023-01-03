package com.hiring.joblisting.respository;

import com.hiring.joblisting.model.Post;

import java.util.List;

public interface SearchRepo
{
    List<Post> findByText(String text);
}
