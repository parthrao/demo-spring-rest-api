package com.example.demo.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id)
		.forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getTopic(String id) {
		return courseRepository.findById(id);
	}
	
	public void addTopic(Course course) {
		courseRepository.save(course);
	}
	
	public void updateTopic(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteTopic(String id) {
		courseRepository.deleteById(id);
	}
}
