package com.hiring.joblisting.respository;

import com.hiring.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo
{
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text)
    {
        final List<Post> search = new ArrayList<Post>();

        MongoDatabase db = client.getDatabase("project");
        MongoCollection<Document> collection = db.getCollection("hirings");

        AggregateIterable<Document> result =   collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                new Document("query", text)
                .append("path",Arrays.asList("techs","desc","profile")))),
                new Document("$sort",
                new Document("exp",1L)),
                new Document("$limit",5L)));

        result.forEach(document -> search.add(converter.read(Post.class,document)));


        return search;
    }
}
