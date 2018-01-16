package com.timesheet.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.timesheet.model.Project;
import com.timesheet.model.Task;
import com.timesheet.model.User;

public interface TaskRepository extends CrudRepository<Task, String> {

}
