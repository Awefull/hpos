package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.EvaluateDao;
import com.heeexy.example.service.EvaluateService;
import com.heeexy.example.util.CommonUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService{
    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<JSONObject> evaluateOneStudioList(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = evaluateDao.evaluateOneStudioList(jsonObject);
        return  list;
    }

    @Override
    public JSONObject evaluate(JSONObject json){
        JSONObject finalEvaluate = new JSONObject();
        float demandEvaluate = json.getFloat("evaluateDemand");
        float abilityEvaluate = json.getFloat("evaluateAbility");
        float planEvaluate = json.getFloat("evaluatePlan");
        float evaluate = json.getFloat("evaluate");
        float demandWeight = 1;
        float abilityWeight = 1;
        float planWeight = 1;
        float finalDemand = 1;
        float finalAbility = 1;
        float finalPlan = 1;
        List<JSONObject> list = evaluateDao.evaluateOneStudioList(json);
        if (list.size() <= 3) {
            finalDemand = demandEvaluate/3;
            finalAbility = abilityEvaluate/2;
            finalPlan = planEvaluate/3;
            evaluate = finalDemand + finalAbility + finalPlan;
        }
        else {
            try {
                File file = new File("./data.xlsx");
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet();
                OutputStream out = new FileOutputStream(file);
                for (int i = 0; i < list.size() ; i++) {
                    Row row = sheet.createRow(i);
                    JSONObject jsonObject = list.get(i);

                    Cell first = row.createCell(0);
                    first.setCellValue(jsonObject.getString("evaluateDemand"));
                    Cell second = row.createCell(1);
                    second.setCellValue(jsonObject.getString("evaluateAbility"));
                    Cell third = row.createCell(2);
                    third.setCellValue(jsonObject.getString("evaluatePlan"));
                }
                workbook.write(out);
                out.close();
                String exe = "python";
                File directory = new File("PCA.py");
                String command = directory.getCanonicalPath();
                command = command.replace("/","\\");
//                String command = "D:\\lab\\hr_and_project_outsourcing_platform\\src\\web\\hpos\\back\\PCA.py";
                String[] cmdArr = new String[] {exe, command};
                Process proc;
                proc = Runtime.getRuntime().exec(cmdArr);
                proc.waitFor();

                String pathName = "./out.txt";
                FileReader reader = new FileReader(pathName);
                BufferedReader br = new BufferedReader(reader);
                String line;
                while((line = br.readLine()) != null) {
                    String[] tt = line.split("\\s+");
                    tt[0] = tt[0].replace("[","0");
                    demandWeight = Float.parseFloat(tt[0]);
                    abilityWeight = Float.parseFloat(tt[1]);
                    tt[2] = tt[2].replace("]","0");
                    planWeight = Float.parseFloat(tt[2]);
                }
                finalDemand = demandEvaluate * demandWeight/3;
                finalAbility = abilityEvaluate * abilityWeight/3;
                finalPlan = planEvaluate * planWeight/3;
                evaluate = (finalDemand + finalAbility + finalPlan)/3;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        finalEvaluate.put("finalDemand", finalDemand);
        finalEvaluate.put("finalAbility", finalAbility);
        finalEvaluate.put("finalPlan", finalPlan);
        finalEvaluate.put("evaluate", evaluate);
        return finalEvaluate;
    }

}
