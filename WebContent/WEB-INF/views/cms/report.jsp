<%@page import="java.io.OutputStream,com.ibm.icu.text.SimpleDateFormat,com.ibm.icu.text.DecimalFormat,com.neil.object.ParticipantObj,org.apache.poi.ss.usermodel.CellStyle,java.util.Date,java.util.ArrayList,java.util.Map,java.util.Set,java.util.LinkedHashMap,org.apache.poi.ss.usermodel.Cell,org.apache.poi.ss.usermodel.Row,org.apache.poi.xssf.usermodel.XSSFSheet,org.apache.poi.xssf.usermodel.XSSFWorkbook"%><%		
		ArrayList<ParticipantObj> pList= (ArrayList<ParticipantObj>)request.getAttribute("pList");
		XSSFWorkbook workbook = new XSSFWorkbook(); 
        XSSFSheet sheet = workbook.createSheet("骏马长城团购表格");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();
        data.put("1", new Object[] {"姓名", "手机","意向车型", "创建时间"});
        int n=2;
        for(ParticipantObj p:pList){
        	data.put(""+n, new Object[] {p.getName(),p.getContact(),p.getCar(),p.getCreate_date()});
        	n++;
        }
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        DecimalFormat doublef = new DecimalFormat("#.##");
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
                else if(obj instanceof Double)
                    cell.setCellValue(doublef.format((Double)obj));
                else if(obj instanceof Long)
                    cell.setCellValue((Long)obj);
                else if(obj instanceof Date){
                	short df = workbook.createDataFormat().getFormat("dd-mmm-yyyy");
                	CellStyle dateCellStyle = workbook.createCellStyle();
                	dateCellStyle.setDataFormat(df);
                    cell.setCellStyle(dateCellStyle);
                	cell.setCellValue((Date)obj);
                }
            }
        }
        
        OutputStream outp = response.getOutputStream();
        try
        {
        	response.setContentType("application/vnd.ms-excel");
        	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        	response.setCharacterEncoding("UTF-8");
        	response.setHeader("Content-Disposition", "attachment; filename=" + "report-" + date + ".xls");
            workbook.write(outp);
            outp.flush();
            outp.close();
            out.clear();
        	out=pageContext.pushBody();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }       
 %>