package com.backend.service;

import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Instructor;
import com.backend.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService
{
    @Autowired
    InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor saveInstructor(Instructor instructor)
    {
        return instructorRepository.save(new Instructor(instructor.getInstructor_name(),instructor.getInstructor_lastname(),instructor.getInstructor_email(),instructor.getInstructor_specialty()));
    }

    @Override
    public List<Instructor> getAllInstructors()
    {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(int id)
    {
        Instructor existingInstructor = instructorRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Instructor","Id",id));
        return existingInstructor;
    }

    @Override
    public Instructor updateInstructor(Instructor instructor, int id)
    {
        Instructor existingInstructor = instructorRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Instructor","Id",id));
        existingInstructor.setInstructor_name(instructor.getInstructor_name());
        existingInstructor.setInstructor_lastname(instructor.getInstructor_lastname());
        existingInstructor.setInstructor_email(instructor.getInstructor_email());
        existingInstructor.setInstructor_specialty(instructor.getInstructor_specialty());
        instructorRepository.save(existingInstructor);
        return existingInstructor;
    }

    @Override
    public void deleteInstructor(int id)
    {
        instructorRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Instructor","Id",id));
        instructorRepository.deleteById(id);
    }
}