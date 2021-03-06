package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Mytest {
    /**
     * 写入标题
     *
     * @param sheet
     * @param rowNum 第几行的行号
     * @param values key:第几列的列号  value:值
     */
    public void genSheetHead(Sheet sheet, int rowNum, Map<Integer, Object> values) {
 
        Row row = sheet.createRow(rowNum);
        for (Integer cellNum : values.keySet()) {
            Cell cell = row.createCell(cellNum);
            Object value = values.get(cellNum);
            generateValue(value, cell);
        }
    }
	
    public void createCell(Row row, int cellNum, Object value) {
        Cell cell = row.createCell(cellNum);
        generateValue(value, cell);
    }

    public void generateValue(Object value, Cell cell) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        } else if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString) value);
        }
    }
	@Test
	public void test1() throws FileNotFoundException, IOException {
        //输入模板文件
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("ceshi.xlsx"));
        SXSSFWorkbook workbook = new SXSSFWorkbook();
 
        //导出文件s
        File file = new File("test2.xlsx");
 
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            Sheet sheet = workbook.getSheet("sheet" + (i + 1));
            if (sheet == null) {
                sheet = workbook.createSheet("sheet" + (i + 1));
            }
//            生成标题
            Map<Integer, Object> firstTitles = new HashMap<>();
            firstTitles.put(0, "部门:");
            firstTitles.put(1, "test12221");
            firstTitles.put(7, "时间:");
            firstTitles.put(8, "2017-09-11");
            genSheetHead(sheet, 0, firstTitles);
 
            Map<Integer, Object> twoTitles = new HashMap<>();
            twoTitles.put(0, "工号：");
            twoTitles.put(1, "test12221");
            twoTitles.put(2, "姓名:");
            twoTitles.put(3, "aaaa");
            genSheetHead(sheet, 1, twoTitles);
 
            for (int rownum = 2; rownum < 100; rownum++) {
                Row row = sheet.createRow(rownum);
                int k = -1;
                createCell(row, ++k, "第 " + rownum + " 行");
                createCell(row, ++k, 34343.123456789);
                createCell(row, ++k, "23.67%");
                createCell(row, ++k, "12:12:23");
                createCell(row, ++k, "2014-10-<11 12:12:23");
                createCell(row, ++k, "true");
                createCell(row, ++k, "false");
                createCell(row, ++k, "fdsa");
                createCell(row, ++k, "123");
                createCell(row, ++k, "321");
                createCell(row, ++k, "3213");
                createCell(row, ++k, "321");
                createCell(row, ++k, "321");
                createCell(row, ++k, "43432");
                createCell(row, ++k, "54");
                createCell(row, ++k, "fal45se");
                createCell(row, ++k, "fal6se");
                createCell(row, ++k, "fal64321se");
                createCell(row, ++k, "fal43126se");
                createCell(row, ++k, "432432");
                createCell(row, ++k, "432432");
                createCell(row, ++k, "r54");
                createCell(row, ++k, "543");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1a");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
                createCell(row, ++k, "few1");
            }
 
        }
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
 
        System.out.println((System.currentTimeMillis()-start));
        out.close();
	}
	 @Test
	 public void contextLoads() throws ClassNotFoundException, SQLException {
	        Class.forName("com.mysql.jdbc.Driver");
	        //2.连接到数据"库"上去
	        Connection conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?characterEncoding=GBK", "root", "admin");
	        //3.构建SQL命令
	        Statement state=(Statement) conn.createStatement();
	        String s="select * from poidemo";
	        ResultSet rs = state.executeQuery(s);
	        List<Vo> list = new ArrayList<Vo>();
	        while(rs.next()) {
	        	Vo vo = new Vo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
	        	list.add(vo);
	        }
	        System.out.println(list.size());
	 
	    // 导出的excel,全文件名
	    final String excelExportDestfilepath = "abc.xlsx";
	 
	        FileOutputStream fos = null;
	        SXSSFWorkbook sxssfWorkbook = null;
	        try {	 
	            /// -> excel到处逻辑
	            long startTime = System.currentTimeMillis();
	            // 获取SXSSFWorkbook实例
	            sxssfWorkbook = new SXSSFWorkbook();
	            Sheet sheet = sxssfWorkbook.createSheet("我是Sheet");
	            // 冻结最左边的两列、冻结最上面的一行
	            // 即：滚动横向滚动条时，左边的第一、二列固定不动;滚动纵向滚动条时，上面的第一行固定不动。
	            sheet.createFreezePane(2, 1);
	            // 设置并获取到需要的样式
	            XSSFCellStyle xssfCellStyleHeader = getAndSetXSSFCellStyleHeader(sxssfWorkbook);
	            XSSFCellStyle xssfCellStyleOne = getAndSetXSSFCellStyleOne(sxssfWorkbook);
	            XSSFCellStyle xssfCellStyleTwo = getAndSetXSSFCellStyleTwo(sxssfWorkbook);
	            // 创建第一行,作为header表头
	            Row header = sheet.createRow(0);
	            // 循环创建header单元格(根据实际情况灵活创建即可)
	            for (int cellnum = 0; cellnum < 11; cellnum++) {
	                Cell cell = header.createCell(cellnum);
	                cell.setCellStyle(xssfCellStyleHeader);
	                // 判断单元格
	                if (cellnum == 0) {
	                    cell.setCellValue("通话ID");
	                } else if (cellnum == 1) {
	                    cell.setCellValue("绑定关系ID");
	                } else if (cellnum == 2) {
	                    cell.setCellValue("主叫号码");
	                } else if (cellnum == 3) {
	                    cell.setCellValue("被叫号码");
	                } else if (cellnum == 4) {
	                    cell.setCellValue("中间号码");
	                } else if (cellnum == 5) {
	                    cell.setCellValue("通话发生时间");
	                } else if (cellnum == 6) {
	                    cell.setCellValue("通话开始时间");
	                } else if (cellnum == 7) {
	                    cell.setCellValue("通话结束时间");
	                } else if (cellnum == 8) {
	                    cell.setCellValue("通话时长(秒)");
	                } else if (cellnum == 9) {
	                    cell.setCellValue("结束发起方");
	                } else {
	                    cell.setCellValue("结束状态（即挂断原因）");
	                }
	            }
	 
	            // 遍历创建行,导出数据
	            for (int rownum = 1; rownum <= list.size(); rownum++) {
	                Row row = sheet.createRow(rownum);
	                // 循环创建单元格
	                for (int cellnum = 0; cellnum < 11; cellnum++) {
	                    Cell cell = row.createCell(cellnum);
	                    // 根据行数,设置该行内的单元格样式
	                    if (rownum % 2 == 1) { // 奇数
	                        cell.setCellStyle(xssfCellStyleOne);
	                    } else { // 偶数
	                        cell.setCellStyle(xssfCellStyleTwo);
	                    }
	                    // 根据单元格所属,录入相应内容
	                    // 将部分数字类型的字符串,转换为Long;以免导出excel后,单元格左上角有三
	                    //    角形(这是excel检查到该单元格内的内容均为数字,但是单元格类型却不是
	                    //    数字,给出的提示),转不转看自己需求灵活处理
	                    if (cellnum == 0) {
	                    	System.out.print(list.get(rownum-1).getCallId()+",");
	                        cell.setCellValue((list.get(rownum - 1).getCallId()));
	                    } else if (cellnum == 1) {
	                    	System.out.print(list.get(rownum-1).getBindId()+",");
	                        cell.setCellValue(list.get(rownum - 1).getBindId());
	                    } else if (cellnum == 2) {
	                    	System.out.print(list.get(rownum-1).getCallNo()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getCallNo());
	                    } else if (cellnum == 3) {
	                    	System.out.print(list.get(rownum-1).getPeerNo()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getPeerNo());
	                    } else if (cellnum == 4) {
	                    	System.out.print(list.get(rownum-1).getTelX()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getTelX());
	                    } else if (cellnum == 5) {
	                    	System.out.print(list.get(rownum-1).getCallTime()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getCallTime());
	                    } else if (cellnum == 6) {
	                    	System.out.print(list.get(rownum-1).getStartTime()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getStartTime());
	                    } else if (cellnum == 7) {
	                    	System.out.print(list.get(rownum-1).getFinishTime()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getFinishTime());
	                    } else if (cellnum == 8) {
	                    	System.out.print(list.get(rownum-1).getCallDuration()+",");
	                        cell.setCellValue(list.get(rownum - 1).getCallDuration());
	                    } else if (cellnum == 9) {
	                    	System.out.print(list.get(rownum-1).getFinishType()+",");
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getFinishType());
	                    } else {
	                    	System.out.println(list.get(rownum-1).getFinishState());
//	                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	                        cell.setCellValue(list.get(rownum - 1).getFinishState());
	 
	                    }
	                }
	            }
	            // 在后面设置sheet
	            setSheet(sheet);
	            fos = new FileOutputStream(new File("F:\\test\\test2.xlsx"));
	            sxssfWorkbook.write(fos);
	            long endTime = System.currentTimeMillis();
	        } catch (Exception e) {
	        } finally {
	            try {
	                if(sxssfWorkbook != null) {
	                    // dispose of temporary files backing this workbook on disk -> 处
	                    //     理SXSSFWorkbook导出excel时，产生的临时文件
	                    sxssfWorkbook.dispose();
	                }
	                if(fos != null) {
	                    fos.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	 
	        }
	    }
	 
	 /**
	     * 设置sheet
	     */
	    private void setSheet(Sheet sheet) {
	        // 设置各列宽度(单位为:字符宽度的1/256)
	        sheet.setColumnWidth(0, 32 * 256);
	        sheet.setColumnWidth(1, 32 * 256);
	        sheet.setColumnWidth(2, 20 * 256);
	        sheet.setColumnWidth(3, 20 * 256);
	        sheet.setColumnWidth(4, 20 * 256);
	        sheet.setColumnWidth(5, 20 * 256);
	        sheet.setColumnWidth(6, 20 * 256);
	        sheet.setColumnWidth(7, 20 * 256);
	        sheet.setColumnWidth(8, 20 * 256);
	        sheet.setColumnWidth(9, 20 * 256);
	        sheet.setColumnWidth(10, 32 * 256);
	    }
	 
	    /**
	     * 获取并设置header样式
	     */
	    private XSSFCellStyle getAndSetXSSFCellStyleHeader(SXSSFWorkbook sxssfWorkbook) {
	        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	        Font font = sxssfWorkbook.createFont();
	        // 字体大小
	        font.setFontHeightInPoints((short) 14);
	        // 字体粗细
	        font.setBoldweight((short) 20);
	        // 将字体应用到样式上面
	        xssfCellStyle.setFont(font);
	        // 是否自动换行
	        xssfCellStyle.setWrapText(false);
	        // 水平居中
	        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	        // 垂直居中
	        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	        return xssfCellStyle;
	    }
	 
	    /**
	     * 获取并设置样式一
	     */
	    private XSSFCellStyle getAndSetXSSFCellStyleOne(SXSSFWorkbook sxssfWorkbook) {
	        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	        XSSFDataFormat format = (XSSFDataFormat)sxssfWorkbook.createDataFormat();
	        // 是否自动换行
	        xssfCellStyle.setWrapText(false);
	        // 水平居中
	        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	        // 垂直居中
	        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	        // 前景颜色
	        xssfCellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
	        xssfCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        // 边框
	        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
	        xssfCellStyle.setBorderRight(BorderStyle.THIN);
	        xssfCellStyle.setBorderTop(BorderStyle.THIN);
	        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
	        xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
	        xssfCellStyle.setDataFormat(format.getFormat("0"));
	        return xssfCellStyle;
	    }
	 
	    /**
	     * 获取并设置样式二
	     */
	    private XSSFCellStyle getAndSetXSSFCellStyleTwo(SXSSFWorkbook sxssfWorkbook) {
	        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
	        XSSFDataFormat format = (XSSFDataFormat)sxssfWorkbook.createDataFormat();
	        // 是否自动换行
	        xssfCellStyle.setWrapText(false);
	        // 水平居中
	        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
	        // 边框
	        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
	        xssfCellStyle.setBorderRight(BorderStyle.THIN);
	        xssfCellStyle.setBorderTop(BorderStyle.THIN);
	        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
	        xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	        xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        // 垂直居中
	        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
	        // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
	        xssfCellStyle.setDataFormat(format.getFormat("0"));
	        return xssfCellStyle;
	    }

}
