package cn.ys.dao;

import cn.ys.entity.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    //根据id查询电池
    public Record findRecordById(String id);

    //查询记录总数
    public int findTotal();

    //查询所有电池信息
    public List<Record> findAll(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    //增加电池信息
    public boolean addRecord(Record record);

    //删除电池by id
    public boolean deleteRecordById(String id);

    //修改电池信息
    public boolean updateRecord(@Param("record") Record record, @Param("key") Integer key);
}
