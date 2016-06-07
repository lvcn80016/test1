package sample.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import sample.entity.Student;

@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

	public List<Student> getList() {
	
		String sql = "SELECT id,maxorderid,maxparkcustid  FROM park_t_synid";
		
		logger.info(sql);
		logger.info("--------------------------------");
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setMaxorderid(rs.getInt("maxorderid"));
				stu.setMaxparkcustid(rs.getInt("maxparkcustid"));
				return stu;
			}

		});
	}
	
}
