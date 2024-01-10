package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.entity.Studentinfo;

@RestController
public class controllercls {
	@Autowired
	private functions functions;
	
    @GetMapping("/students")
    public ResponseEntity<List<Studentinfo>> getall()
    {
    	try {
    		List<Studentinfo> list=this.functions.getall();
    		if(!list.isEmpty())
    		{
    			return ResponseEntity.ok(list);
    		}
    		else
    		{
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    		
    	}
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Studentinfo> get(@PathVariable("id")int id)
    {
    	try {
    		Optional<Studentinfo> in=this.functions.getbyid(id);
    		Studentinfo info=in.get();
    		return ResponseEntity.ok(info);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
    @PostMapping("/students")
    public ResponseEntity<List<Studentinfo>> addall(@RequestBody List<Studentinfo> adl)
    {
    	try {
    	List<Studentinfo> li=this.functions.saveall(adl);
    	return ResponseEntity.ok(li);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();   	}
    }
    @PostMapping("/student")
    public ResponseEntity<Studentinfo> addone(@RequestBody Studentinfo adl)
    {
    	try {
    	Studentinfo li=this.functions.save(adl);
    	return ResponseEntity.ok(li);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();   	}
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id)
    {
    	this.functions.delete(id);
    	return ResponseEntity.status(HttpStatus.OK).build();   
    	}
    @DeleteMapping("/students")
    public ResponseEntity<Void> deleteall()
    {
    	this.functions.deleteall();
    	return ResponseEntity.status(HttpStatus.OK).build();   
    	}
    @PutMapping("/student/{id}")
    public ResponseEntity<Studentinfo> update(@RequestBody Studentinfo stu,@PathVariable("id")int id )
    {
    	try
    	{
    	Studentinfo study=this.functions.update(stu, id);
    	return ResponseEntity.ok(study);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    	
    }

}
