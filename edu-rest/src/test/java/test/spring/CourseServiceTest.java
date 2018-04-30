package test.spring;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.rest.pojo.PageResult;
import com.edu.rest.pojo.StuCourseVo;
import com.edu.rest.service.CourseService;

public class CourseServiceTest {
	@Test
	public void TestGetStuCoursesByCourseId(){
		ApplicationContext atx = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		CourseService courseService = atx.getBean(CourseService.class);
		PageResult result = courseService.getStuCoursesByCourseId(5, "1234567", "04", 1, 10);
		List<StuCourseVo> list = (List<StuCourseVo>) result.getList();
		for(StuCourseVo vo : list) {
			System.out.println(vo.getMajorName());
		}
	}
}
