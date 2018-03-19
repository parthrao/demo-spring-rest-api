 package com.example.demo.courses;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id); 
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getTopic(@PathVariable String topicId, @PathVariable String id) {
		return courseService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value= "/topics/{topicId}/courses") 
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "","" ));
		courseService.addTopic(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT ,value= "/topics/{topicId}/courses/{id}") 
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "","" ));
		courseService.updateTopic(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE ,value= "/topics/{topicId}/courses/{id}") 
	public void deleteTopic(@PathVariable String topicId, @PathVariable String id) {
		courseService.deleteTopic(id);
	}
}
