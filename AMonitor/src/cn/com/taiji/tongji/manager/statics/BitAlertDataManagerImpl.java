package cn.com.taiji.tongji.manager.statics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.manager.pub.FileHelper;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.TimeTools;
import cn.com.taiji.tongji.dao.statics.BitAlertDataDao;
import cn.com.taiji.tongji.entity.statics.BitAlertData;
import cn.com.taiji.tongji.model.statics.BitAlertDataModel;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月24日 上午8:03:54   
* 修改人：王金鑫     
* 修改时间：2016年1月24日 上午8:03:54   
* 修改备注：   
* @version    
*    
*/
@Service("bitAlertDataManager")
public class BitAlertDataManagerImpl extends AbstractManager implements BitAlertDataManager
{
	@Autowired
	private BitAlertDataDao bitAlertDataDao;

	@Override
	public Pagination queryPagn(BitAlertDataModel queryModel)
	{
		return this.bitAlertDataDao.pagn(queryModel.getBrand(),queryModel.getStartTime(),queryModel.getEndTime(), queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public BitAlertData findById(Integer id)
	{
		return bitAlertDataDao.findById(id);
	}

	@Override
	public File generateExcel(BitAlertDataModel bitAlertDataModel)
	{
		String fileName ="Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";  
        File outFile=new File(FileHelper.getTmpPath()+File.separator+fileName);
        if(outFile.exists())outFile.delete();
       
		int startNo=Integer.parseInt(bitAlertDataModel.getStartNo());
		int endNo=Integer.parseInt(bitAlertDataModel.getEndNo());
		bitAlertDataModel.setPageNo(startNo);
		int pageSize=(endNo-startNo+1)*bitAlertDataModel.getPageSize();
		bitAlertDataModel.setPageSize(pageSize);
		Pagination pagn=this.bitAlertDataDao.pagn(bitAlertDataModel.getBrand(),bitAlertDataModel.getStartTime(),bitAlertDataModel.getEndTime(),bitAlertDataModel.getPageNo(),bitAlertDataModel.getPageSize());
		List<BitAlertData> datas=pagn.getResult(BitAlertData.class);
		
		int columnCount=24;
		try{  
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象  
            HSSFSheet sheet = workbook.createSheet("业务异常报警数据");                  // 创建工作表  
              
            // 产生表格标题行  
            HSSFRow rowm = sheet.createRow(0);  
            HSSFCell cellTiltle = rowm.createCell(0);  
            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
            cellTiltle.setCellValue("启动时间"); 
            cellTiltle = rowm.createCell(1);
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("退出时间"); 
            cellTiltle = rowm.createCell(2); 
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("使用时长"); 
            cellTiltle = rowm.createCell(3);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("手机品牌"); 
            cellTiltle = rowm.createCell(4);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("手机型号"); 
            cellTiltle = rowm.createCell(5);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("Android版本"); 
            cellTiltle = rowm.createCell(6);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("运营商"); 
            cellTiltle = rowm.createCell(7);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CellId号"); 
            cellTiltle = rowm.createCell(8);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("本机IP"); 
            cellTiltle = rowm.createCell(9);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("应用进程名称");
            cellTiltle = rowm.createCell(10);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("网络类型");
            cellTiltle = rowm.createCell(11);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("IMEI");
            cellTiltle = rowm.createCell(12);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("IMSI");
            cellTiltle = rowm.createCell(13);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("LAC");
            cellTiltle = rowm.createCell(14);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSRP");
            cellTiltle = rowm.createCell(15);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSRQ");
            cellTiltle = rowm.createCell(16);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSSNR");
            cellTiltle = rowm.createCell(17);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CPU占比");
            cellTiltle = rowm.createCell(18);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("UID");
            cellTiltle = rowm.createCell(19);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("PID");
            cellTiltle = rowm.createCell(20);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("进程数");
            cellTiltle = rowm.createCell(21);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("内存使用比");
            cellTiltle = rowm.createCell(22);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("发送总字节量");
            cellTiltle = rowm.createCell(23);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("接收总字节量");
        	
            //将查询出的数据设置到sheet对应的单元格中  
            for(int i=0;i<datas.size();i++){  
            	BitAlertData data=datas.get(i);
                HSSFRow row = sheet.createRow(i+1);//创建所需的行数  
                HSSFCell  cell = row.createCell(0);   //设置单元格的数据类型  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
                cell.setCellValue(TimeTools.getCnDateTimeStr(data.getLauntime())); 
                // cell.setCellValue(data.getLauntime()); 
                cell = row.createCell(1);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getExittime()); 
                cell = row.createCell(2); 
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getUsetime()); 
                cell = row.createCell(3);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getBrand()); //"手机品牌"
                cell = row.createCell(4);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getType()); //"手机型号"
                cell = row.createCell(5);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getVersion()); //"Android版本"
                cell = row.createCell(6);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getCorporation()); //"运营商"
                cell = row.createCell(7);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getCid()); //"CellId号"
                cell = row.createCell(8);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getLocalIp()); //"本机IP"
                
                
                cellTiltle = row.createCell(9);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getAppName());//"应用进程名称"
                cellTiltle = row.createCell(10);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getNetType());//"网络类型"
                cellTiltle = row.createCell(11);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getIMEI());//"IMEI"
                cellTiltle = row.createCell(12);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getIMSI());//"IMSI"
                cellTiltle = row.createCell(13);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getLAC());//"LAC"
                cellTiltle = row.createCell(14);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getRSRP());//"RSRP"
                cellTiltle = row.createCell(15);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getRSRQ());//"RSRQ"
                cellTiltle = row.createCell(16);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getRSSNR());//"RSSNR"
                cellTiltle = row.createCell(17);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getCpuRate());//"CPU占比"
                cellTiltle = row.createCell(18);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getUid());//"UID"
                cellTiltle = row.createCell(19);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getPid());//"PID"
                cellTiltle = row.createCell(20);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getPidNumber());//"进程数"
                cellTiltle = row.createCell(21);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getMemRate());//"内存使用比"
                cellTiltle = row.createCell(22);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getTxByte());//"发送总字节量"
                cellTiltle = row.createCell(23);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getRxByte());//"接收总字节量"
            }  
            //让列宽随着导出的列长自动适应  
            for (int colNum = 0; colNum < columnCount; colNum++) {  
                int columnWidth = sheet.getColumnWidth(colNum) / 256;  
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {  
                    HSSFRow currentRow;  
                    //当前行未被使用过  
                    if (sheet.getRow(rowNum) == null) {  
                        currentRow = sheet.createRow(rowNum);  
                    } else {  
                        currentRow = sheet.getRow(rowNum);  
                    }  
                    if (currentRow.getCell(colNum) != null) {  
                        HSSFCell currentCell = currentRow.getCell(colNum);  
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {  
                            int length = currentCell.getStringCellValue().getBytes().length;  
                            if (columnWidth < length) {  
                                columnWidth = length;  
                            }  
                        }  
                    }  
                }  
                if(colNum == 0){  
                    sheet.setColumnWidth(colNum, (columnWidth-2) * 256);  
                }else{  
                    sheet.setColumnWidth(colNum, (columnWidth+4) * 256);  
                }  
            }  
              
            if(workbook !=null){  
                try  
                {  
                	outFile.createNewFile();
                    workbook.write(new FileOutputStream(outFile));  
                }  
                catch (IOException e)  
                {  
                    e.printStackTrace();  
                } 
                finally{
                	if(workbook!=null)workbook.close();
                }
            }
        }catch(Exception e){  
            e.printStackTrace();  
        }  
		return outFile;
	}

}

