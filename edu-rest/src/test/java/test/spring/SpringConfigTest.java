package test.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.common.pojo.Comment;
import com.edu.common.pojo.HttpResult;
import com.edu.common.utils.JsonUtils;
import com.edu.rest.component.JedisClient;
import com.edu.rest.pojo.CommentVo;
import com.edu.rest.service.CommentService;

public class SpringConfigTest {
	
	@Test
	public void test() {
		ApplicationContext atx = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
		
		CommentService commentService = atx.getBean(CommentService.class);
		Comment comment = new Comment();
		comment.setCommentContent("hello world");
		comment.setKpId(12);
		comment.setUserName("04151307 陈晓涛");
		HttpResult result = commentService.insertComment(comment);
		System.out.println(result.getMsg());
	}
	
	
}
