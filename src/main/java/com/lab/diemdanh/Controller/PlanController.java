package com.lab.diemdanh.Controller;

import com.lab.diemdanh.Entity.Plan;
import com.lab.diemdanh.Entity.Semester;
import com.lab.diemdanh.Service.PlanService;
import com.lab.diemdanh.Service.SemesterService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class PlanController {
    @Autowired
    private PlanService planService;

    @Autowired
    private SemesterService semesterService;
    @PostMapping("/plan/import")
    public ResponseEntity<String> addPlan(@RequestParam("file") MultipartFile reapExcelDataFile) throws Exception{

        List<Plan> plans = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(reapExcelDataFile.getInputStream());

            Sheet sheet = workbook.getSheetAt(0);


            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();


                Iterator<Cell> cellIterator = row.cellIterator();
                Plan plan = new Plan();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            plan.setClassName(cell.getStringCellValue());
                            break;
                        case 1:
                            plan.setSubjectId(cell.getStringCellValue());
                            break;
                        case 2:
                            plan.setDept(cell.getStringCellValue());
                            break;
                        case 3:
                            plan.setSlotDays(cell.getStringCellValue());
                            break;
                        case 4:
                            plan.setSlot1(cell.getStringCellValue());
                            break;
                        case 5:
                            plan.setSlot2(cell.getStringCellValue());
                            break;
                        case 6:
                            plan.setRoom(cell.getStringCellValue());
                            break;
                        case 7:
                            if (cell.getStringCellValue() != null)
                                plan.setRoom2(cell.getStringCellValue());
                            else plan.setRoom2("");
                            break;
                    }
                }
                plan.setSemesterId(1);
                Semester semester = semesterService.findById(1);
                plan.setStartDate(semester.getStartDate());
                plan.setEndDate(semester.getEndDate());
                plans.add(plan);
            }

            // Đóng workbook sau khi hoàn thành
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu có
            throw new Exception("Import failed");
        }

        for (Plan p : plans)
            planService.addPlan(p);

        return ResponseEntity.ok("Success");
    }
}
