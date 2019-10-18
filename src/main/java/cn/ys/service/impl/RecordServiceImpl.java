package cn.ys.service.impl;

import cn.ys.dao.RecordMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.Record;
import cn.ys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public PageList<Record> findAll(Integer page,Integer rows) {
        List<Record> listrecord = recordMapper.findAll((page-1)*rows,rows);
        int total = recordMapper.findTotal();
        PageList<Record> listrecords = new PageList<>();
        listrecords.setTotal(total);
        listrecords.setRows(listrecord);
        return listrecords;
    }

    @Override
    public boolean addRecord(Record record) {
        boolean res = recordMapper.addRecord(record);
        return res;
    }

    @Override
    public Record findRecordById(String id) {
        Record record = recordMapper.findRecordById(id);
        return record;
    }

    @Override
    public boolean deleteRecordById(String id) {
        boolean res = recordMapper.deleteRecordById(id);
        return res;
    }

    @Override
    public boolean updateRecord(Record record,Integer key){
        boolean res = recordMapper.updateRecord(record, key);
        return res;
    }
}
