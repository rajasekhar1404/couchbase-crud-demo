package com.couchbase.repo;

import com.couchbase.entity.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouchbaseRepo extends CouchbaseRepository<User, String> {

}
