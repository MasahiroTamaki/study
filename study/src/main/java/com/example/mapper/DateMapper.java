package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Date;

@Mapper
public interface DateMapper {
    
	@Select("select * from datemaster")
	List<Date> select();

	@Select("select * from datemaster where dateId = #{dateId}")
	Date selectPK(String dateId);

	@Insert("insert into datemaster (dateId, dateName, adjustmentYear, adjustmentMonth, adjustmentDay) values (#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void save(Date date);

	@Update("update datemaster set dateId = #{dateId}, dateName = #{dateName}, adjustmentYear = #{adjustmentYear}, adjustmentMonth = #{adjustmentMonth}, adjustmentDay = #{adjustmentDay} where dateId = #{dateId}")
	void update(Date date);

	@Delete("delete from datemaster where dateId = #{dateId}")
	void deletePK(String dateId);
}
