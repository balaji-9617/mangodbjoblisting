package com.hiring.joblisting.respository;

import com.hiring.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String>
{
}
