package com.example.crudtemplatenew.repository;

import com.example.crudtemplatenew.entity.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeReporitory {

    private HashOperations hashOperations=null;
    private RedisTemplate redisTemplate =null;

   public EmployeeReporitory(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void saveEmployee(Employee employee){

        hashOperations.put("EMPLOYEE", employee.getId(), employee);
    }
    public List<Employee> findAll(){

        return hashOperations.values("EMPLOYEE");
    }
    public Employee findById(Integer id){

        return (Employee) hashOperations.get("EMPLOYEE", id);
    }

    public void updathOpee(Employee employee){
            saveEmployee(employee);
        }
        public void delete(Integer id){
            hasrations.delete("EMPLOYEE", id);
    }

}
