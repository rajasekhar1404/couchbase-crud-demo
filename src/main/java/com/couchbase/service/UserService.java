package com.couchbase.service;

import com.couchbase.entity.User;
import com.couchbase.repo.CouchbaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.QueryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private CouchbaseTemplate couchbaseTemplate;
//    private CouchbaseRepo couchbaseRepo;

    public User create(User user) {
//        return couchbaseRepo.save(user);
        return couchbaseTemplate.save(user);
    }

    public User get(String id) {
//        return couchbaseRepo.findById(id).orElseThrow();
        return couchbaseTemplate.findById(User.class).one(id);
    }

    public List<User> getAll() {
//        return couchbaseRepo.findAll();
        return couchbaseTemplate.findByQuery(User.class).all();
    }

    public User update(User user) {
//        User oldUser = couchbaseRepo.findById(user.getId()).orElseThrow();
//        return couchbaseRepo.save(user);

        User oldUser = couchbaseTemplate.findById(User.class).one(user.getId());
        return couchbaseTemplate.save(user);
    }

    public String delete(String id) {
//        couchbaseRepo.deleteById(id);
        couchbaseTemplate.removeById(User.class).one(id);
        return "Success";
    }

    public User findByEmail(String email) {
        Query query = new Query().addCriteria(QueryCriteria.where("email").is(email));
        return couchbaseTemplate.findByQuery(User.class).matching(query).one().get();
    }

    public User findByNameAndAge(String name, Integer age) {
        Query query = new Query(QueryCriteria.where("name").is(name).and("age").lt(age));
        return couchbaseTemplate.findByQuery(User.class).matching(query).one().get();
    }

}
