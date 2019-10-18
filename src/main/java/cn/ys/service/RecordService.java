package cn.ys.service;

import cn.ys.dto.PageList;
import cn.ys.entity.Record;

public interface RecordService {

    //查询所有记录信息
    PageList<Record> findAll(Integer page, Integer rows);

    //增加车主信息
    boolean addRecord(Record record);

    //根据id删除车主信息
    boolean deleteRecordById(String id);

    //根据id查找车主信息
    Record findRecordById(String id);

    //修改车主信息
    boolean updateRecord(Record record, Integer key);
}
