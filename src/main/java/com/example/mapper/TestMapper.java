package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Test;

@Mapper
public interface TestMapper {

	@Select("SELECT * FROM test")
	List<Test> findAll();
	
	@Select("SELECT * FROM test WHERE no = #{no}")
	Test findOne(int no);
	
	@Delete("DELETE FROM test WHERE no = #{no}")
	void delete(int no);

	@Insert("INSERT INTO test(name, age) VALUES (#{name}, #{age})")
	void create(@Param("name") String name, @Param("age") String age);

	@Update("UPDATE test SET name = #{name}, age = #{age} WHERE no = #{no}")
	void update(@Param("no") int no, @Param("name") String name, @Param("age") String age);


}
