package com.timesheet.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.timesheet.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
