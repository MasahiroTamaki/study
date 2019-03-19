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

	@Insert("insert into datemaster (dateId, dateName, ajustmentYear, ajustmentMonth, ajustmentDay) values (#{dateId}, #{dateName}, #{ajustmentYear}, #{ajustmentMonth}, #{ajustmentDay})")
	void save(Date date);

	@Update("update datemaster set dateId = #{dateId}, dateName = #{dateName}, ajustmentYear = #{ajustmentYear}, ajustmentMonth = #{ajustmentYear}, ajustmentDay = #{ajustmentYear}")
	void update(Date date);

	@Delete("delete from datemaster where dateId = #{dateId}")
	void deletePK(String dateId);
}
