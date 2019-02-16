package com.example.mapper;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import com.example.domain.Date;

@Mapper
public interface DateMapper {
      List<Date> selectAll();
}
