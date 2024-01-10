package com.restapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.entity.Studentinfo;
@Component
public class functions {
	@Autowired
   public services services;
	public List<Studentinfo> getall()
	{
		List<Studentinfo> list=(List<Studentinfo>)services.findAll();
		return list;
	}
	public Optional<Studentinfo> getbyid(int id)
	{
		Optional<Studentinfo> inf=services.findById(id);
		return inf;
	}
	public List<Studentinfo> saveall(List<Studentinfo> inf)
	{
		 return (List<Studentinfo>)services.saveAll(inf);
	}
	public Studentinfo save(Studentinfo inf)
	{
		return services.save(inf);
	}
	public void delete(int id)
	{
		  services.deleteById(id);
	}
	public void deleteall()
	{
		services.deleteAll();
	}
    public Studentinfo update(Studentinfo stud,int id)
    {
    	stud.setId(id);
    	return services.save(stud);
    }
    public byte[] upload(@RequestParam("file")MultipartFile file) throws IOException
    {
    	System.out.println(file.getOriginalFilename());
    	System.out.println(file.getContentType());
    	System.out.println(file.getName());
    	InputStream ins=file.getInputStream();
        byte data[]=new byte[ins.available()];
        ins.read(data);
        return data;
    	}
}
