package com.heeexy.example.util;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.config.exception.CommonJsonException;
import com.heeexy.example.service.EvaluateService;
import com.heeexy.example.util.constants.Constants;
import com.heeexy.example.util.constants.ErrorEnum;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: hxy
 * @description: 本后台接口系统常用的json工具类
 * @date: 2017/10/24 10:12
 */
public class CommonUtil{
	@Autowired
	private EvaluateService evaluateService;

	/**
	 * 返回一个info为空对象的成功消息的json
	 */
	public static JSONObject successJson() {
		return successJson(new JSONObject());
	}

	/**
	 * 返回一个返回码为100的json
	 */
	public static JSONObject successJson(Object info) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", Constants.SUCCESS_CODE);
		resultJson.put("msg", Constants.SUCCESS_MSG);
		resultJson.put("info", info);
		return resultJson;
	}

	/**
	 * 返回错误信息JSON
	 */
	public static JSONObject errorJson(ErrorEnum errorEnum) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", errorEnum.getErrorCode());
		resultJson.put("msg", errorEnum.getErrorMsg());
		resultJson.put("info", new JSONObject());
		return resultJson;
	}

	/**
	 * 查询分页结果后的封装工具方法
	 *
	 * @param requestJson 请求参数json,此json在之前调用fillPageParam 方法时,已经将pageRow放入
	 * @param list        查询分页对象list
	 * @param totalCount  查询出记录的总条数
	 */
	public static JSONObject successPage(final JSONObject requestJson, List<JSONObject> list, int totalCount) {
		int pageRow = requestJson.getIntValue("pageRow");
		int totalPage = getPageCounts(pageRow, totalCount);
		JSONObject result = successJson();
		JSONObject info = new JSONObject();
		info.put("list", list);
		info.put("totalCount", totalCount);
		info.put("totalPage", totalPage);
		result.put("info", info);
		return result;
	}


	/**
	 * 查询分页结果后的封装工具方法
	 *
	 * @param list 查询分页对象list
	 */
	public static JSONObject successPage(List<JSONObject> list, int count) {
		JSONObject result = successJson();
		JSONObject info = new JSONObject();
		info.put("list", list);
		info.put("count", count);
		result.put("info", info);
		return result;
	}



	/**
	 * 查询分页结果后的封装工具方法
	 *
	 * @param list 查询分页对象list
	 */
	public static JSONObject successPage(List<JSONObject> list) {
		JSONObject result = successJson();
		JSONObject info = new JSONObject();
		info.put("list", list);
		result.put("info", info);
		return result;
	}

	/**
	 * 查询分页结果后的封装工具方法
	 *
	 * @param count 查询分页对象list
	 */
	public static JSONObject successPage(int count) {
		JSONObject result = successJson();
		JSONObject info = new JSONObject();
		info.put("count", count);
		return result;
	}

	public static JSONObject successPage(JSONObject json) {
		JSONObject result = successJson();
		JSONObject info = new JSONObject();
		info.put("json", json);
		result.put("info", info);
		return result;
	}

//	public JSONObject evaluate(JSONObject json) throws Exception {
//		JSONObject finalEvaluate = new JSONObject();
//		float demandEvaluate = json.getFloat("evaluateDemand");
//		float abilityEvaluate = json.getFloat("evaluateAbility");
//		float planEvaluate = json.getFloat("evaluatePlan");
//		float demandWeight = 1;
//		float abilityWeight = 1;
//		float planWeight = 1;
//		float finalDemand;
//		float finalAbility;
//		float finalPlan;
//		List<JSONObject> list = evaluateService.evaluateOneStudioList(json);
//		if (list == null) {
//			finalDemand = demandEvaluate/3;
//			finalAbility = abilityEvaluate/2;
//			finalPlan = planEvaluate/3;
//		}
//		else {
//			File file = new File("./data.xlsx");
//			HSSFWorkbook workbook = new HSSFWorkbook();
//			HSSFSheet sheet = workbook.createSheet();
//
//			for (int i = 0; i < list.size(); i++) {
//				HSSFRow row = sheet.createRow(i);
//				JSONObject jsonObject  = list.get(i);
//				for (int j = 0; j < 3; j++) {
//					HSSFCell first = row.createCell(0);
//					first.setCellValue(jsonObject.getString("evaluateDemand"));
//					HSSFCell second = row.createCell(0);
//					second.setCellValue(jsonObject.getString("evaluateAbility"));
//					HSSFCell third = row.createCell(0);
//					third.setCellValue(jsonObject.getString("evaluatePlan"));
//				}
//				OutputStream out = new FileOutputStream(file);
//				workbook.write(out);
//				out.close();
////			FileOutputStream fos = new FileOutputStream(file, true);
////			PrintStream ps = new PrintStream(fos);
////			String str = "" + jsonObject.getString("evaluateDemand") + " " + jsonObject.getString("evaluateAbility") + " " + jsonObject.getString("evaluatePlan");
////			ps.print(str);
////			ps.close();
//			}
//			Process proc;
//			proc = Runtime.getRuntime().exec("python ./PCA.py");
//			proc.waitFor();
//			String pathName = "./out.txt";
//			FileReader reader = new FileReader(pathName);
//			BufferedReader br = new BufferedReader(reader);
//			String line;
//			while((line = br.readLine()) != null) {
//				String[] tt = line.split("\\s+");
//				tt[0] = tt[0].replace("[","0");
//				demandWeight = Float.parseFloat(tt[0]);
//				abilityWeight = Float.parseFloat(tt[1]);
//				tt[2] = tt[2].replace("]","0");
//				planWeight = Float.parseFloat(tt[2]);
//			}
//			finalDemand = demandEvaluate * demandWeight;
//			finalAbility = abilityEvaluate * abilityWeight;
//			finalPlan = planEvaluate * planWeight;
//		}
//		finalEvaluate.put("finalDemand", finalDemand);
//		finalEvaluate.put("finalAbility", finalAbility);
//		finalEvaluate.put("finalPlan", finalPlan);
//		return finalEvaluate;
//	}

	/**
	 * 获取总页数
	 *
	 * @param pageRow   每页行数
	 * @param itemCount 结果的总条数
	 */
	private static int getPageCounts(int pageRow, int itemCount) {
		if (itemCount == 0) {
			return 1;
		}
		return itemCount % pageRow > 0 ?
				itemCount / pageRow + 1 :
				itemCount / pageRow;
	}

	/**
	 * 将request参数值转为json
	 */
	public static JSONObject request2Json(HttpServletRequest request) {
		JSONObject requestJson = new JSONObject();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] pv = request.getParameterValues(paramName);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pv.length; i++) {
				if (pv[i].length() > 0) {
					if (i > 0) {
						sb.append(",");
					}
					sb.append(pv[i]);
				}
			}
			requestJson.put(paramName, sb.toString());
		}
		return requestJson;
	}

	/**
	 * 将request转JSON
	 * 并且验证非空字段
	 */
	public static JSONObject convert2JsonAndCheckRequiredColumns(HttpServletRequest request, String requiredColumns) {
		JSONObject jsonObject = request2Json(request);
		hasAllRequired(jsonObject, requiredColumns);
		return jsonObject;
	}

	/**
	 * 验证是否含有全部必填字段
	 *
	 * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
	 */
	public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
		if (!StringTools.isNullOrEmpty(requiredColumns)) {
			//验证字段非空
			String[] columns = requiredColumns.split(",");
			String missCol = "";
			for (String column : columns) {
				Object val = jsonObject.get(column.trim());
				if (StringTools.isNullOrEmpty(val)) {
					missCol += column + "  ";
				}
			}
			if (!StringTools.isNullOrEmpty(missCol)) {
				jsonObject.clear();
				jsonObject.put("code", ErrorEnum.E_90003.getErrorCode());
				jsonObject.put("msg", "缺少必填参数:" + missCol.trim());
				jsonObject.put("info", new JSONObject());
				throw new CommonJsonException(jsonObject);
			}
		}
	}

	/**
	 * 在分页查询之前,为查询条件里加上分页参数
	 *
	 * @param paramObject    查询条件json
	 * @param defaultPageRow 默认的每页条数,即前端不传pageRow参数时的每页条数
	 */
	private static void fillPageParam(final JSONObject paramObject, int defaultPageRow) {
		int pageNum = paramObject.getIntValue("pageNum");
		pageNum = pageNum == 0 ? 1 : pageNum;
		int pageRow = paramObject.getIntValue("pageRow");
		pageRow = pageRow == 0 ? defaultPageRow : pageRow;
		paramObject.put("offSet", (pageNum - 1) * pageRow);
		paramObject.put("pageRow", pageRow);
		paramObject.put("pageNum", pageNum);
		//删除此参数,防止前端传了这个参数,pageHelper分页插件检测到之后,拦截导致SQL错误
		paramObject.remove("pageSize");
	}

	/**
	 * 分页查询之前的处理参数
	 * 没有传pageRow参数时,默认每页10条.
	 */
	public static void fillPageParam(final JSONObject paramObject) {
		fillPageParam(paramObject, 10);
	}
}
