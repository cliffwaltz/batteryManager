package cn.ys.controller;

import cn.ys.dto.PageList;
import cn.ys.entity.Record;
import cn.ys.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @RequestMapping("findall")
    @ResponseBody
    public PageList<Record> findAll(Integer page, Integer rows){
        PageList<Record> listrecord = recordService.findAll(page,rows);
        return listrecord;
    }

    @RequestMapping("addrecord")
    @ResponseBody
    public boolean addRecord(Record record){
        System.out.println(record);
        boolean res = recordService.addRecord(record);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByRecordId(String id){
        System.out.println(id);
        boolean res = recordService.deleteRecordById(id);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Record findRecordById(String id){
        System.out.println(id);
        Record record = recordService.findRecordById(id);
        return record;
    }

    @RequestMapping("updaterecord")
    @ResponseBody
    public boolean updateRecord(Record record,Integer key){
        System.out.println(record);
        System.out.println("key:  "+key);
        boolean res = recordService.updateRecord(record,key);
        return res;
    }
}
