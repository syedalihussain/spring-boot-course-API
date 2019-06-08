package io.package1.springbootstarter.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	private List<Course> courses = new ArrayList<>(Arrays.asList(
			new Course("spring", "Spring Framework", "Spring Framework Description"),
			new Course("java", "Core Java", "Core Java Description"),
			new Course("javascript", "Javascript", "Javascript Description")
			));

	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
				.forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String id) {
		/*for (int i = 0; i < courses.size(); i++) {
			Course t = courses.get(i);
			if (t.getId().equals(id)) {
				courses.set(i, course);
				return;
			}
		}*/
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		//	courses.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
