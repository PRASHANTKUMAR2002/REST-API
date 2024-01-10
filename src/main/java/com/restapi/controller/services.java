package com.restapi.controller;

import org.springframework.data.repository.CrudRepository;

import com.restapi.entity.Studentinfo;
public interface services extends CrudRepository<Studentinfo,Integer>{

}
