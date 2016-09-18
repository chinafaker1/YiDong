package cn.com.taiji.tongji.manager.statics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.manager.JsonManagerException;
import cn.com.taiji.common.manager.pub.FileHelper;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.TimeTools;
import cn.com.taiji.tongji.dao.Jdbc;
import cn.com.taiji.tongji.dao.statics.BitDataDao;
import cn.com.taiji.tongji.entity.statics.BitData;
import cn.com.taiji.tongji.entity.statics.BitData1;
import cn.com.taiji.tongji.model.statics.BitDataModel;
import cn.com.taiji.tongji.model.statics.BitDataView;
import cn.com.taiji.tongji.model.statics.PieModel;
import net.sf.json.JSONObject;

/**
 * 
 * 类描述： 创建人：王金鑫 创建时间：2015年11月21日 下午12:34:47 修改人：王金鑫 修改时间：2015年11月21日 下午12:34:47
 * 修改备注：
 * 
 * @version
 * 
 */
@Service("bitDataManager")
public class BitDataManagerImpl extends AbstractManager implements BitDataManager
{
	@Autowired
	private BitDataDao bitDataDao;

	@Override
	public Pagination queryPagn(BitDataModel queryModel)
	{
		return this.bitDataDao.pagn(queryModel.getBrand(), queryModel.getStartTime(),queryModel.getEndTime(),queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public BitData add(BitData vo) throws JsonManagerException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BitData update(BitData vo) throws JsonManagerException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void detele(String id) throws JsonManagerException
	{
		this.bitDataDao.deleteById(id);
	}

	@Override
	public BitData findById(Integer id)
	{
		return this.bitDataDao.findById(id);
	}

	@Override
	public Pagination pagnModel(BitDataModel queryModel)
	{
		return this.bitDataDao.pagnModel(queryModel);
	}

	@Override
	public List<BitDataView> getDataViews(BitDataModel queryModel)
	{
		String hql="";
		switch(queryModel.getDataType())
		{
//		BRAND("手机品牌"),TYPE("手机型号"),VERSION("Android版本"),
//		LOCALIP("本机IP地址"),IMEI("IMEI"),IMSI("IMSI"),APPNAME("应用进程名称"),
//		NETTYPE("应用进程名称"),CID("CID"),LAC("LAC");
		case BRAND:
			hql="select brand,count(brand) from cn.com.taiji.tongji.entity.statics.BitData  group by brand order by count(brand) desc";
			break;
		case TYPE:
			hql="select type,count(type) from cn.com.taiji.tongji.entity.statics.BitData  group by type order by count(type) desc";
			break;
		case VERSION:
			hql="select version,count(version) from cn.com.taiji.tongji.entity.statics.BitData  group by version order by count(version) desc";
			break;
		case LOCALIP:
			hql="select localIp,count(localIp) from cn.com.taiji.tongji.entity.statics.BitData  group by localIp order by count(localIp) desc";
			break;
		case IMEI:
			hql="select IMEI,count(IMEI) from cn.com.taiji.tongji.entity.statics.BitData  group by IMEI order by count(IMEI) desc";
			break;
		case IMSI:
			hql="select IMSI,count(IMSI) from cn.com.taiji.tongji.entity.statics.BitData  group by IMSI order by count(IMSI) desc";
			break;
		case APPNAME:
			hql="select appName,count(appName) from cn.com.taiji.tongji.entity.statics.BitData  group by appName order by count(appName) desc";
			break;
		case Enodeb_id:
			hql="select enodbId,count(enodbId) from cn.com.taiji.tongji.entity.statics.BitData1  group by enodbId order by count(enodbId) desc";
			break;
		case cell_id:
			hql="select cellId,count(cellId) from cn.com.taiji.tongji.entity.statics.BitData1  group by cellId order by count(cellId) desc";
			break;
		case TAC:
			hql="select tac,count(tac) from cn.com.taiji.tongji.entity.statics.BitData1  group by tac order by count(tac) desc";
			break;
		}
		queryModel.setHql(hql);
		List<Object[]> objects=this.bitDataDao.queryList(queryModel);
		List<BitDataView> views=new ArrayList<BitDataView>();
		for(Object[] object:objects)
		{
			BitDataView view=new BitDataView();
			view.setName((String)object[0]);
			view.setCount((Long)object[1]);
			views.add(view);
		}
		if(views.size()>10)
			views=views.subList(0, 10);
		return views;
	}

	@Override
	public String getDataViewsForCharts(List<BitDataView> views)
	{
		JSONObject json=new JSONObject();
		List<PieModel> datas=new ArrayList<>();
		List<String> names=new ArrayList<>();
		for(BitDataView vo:views)
	    {
			names.add(vo.getName());
			PieModel model=new PieModel(vo.getName(),vo.getCount());
			datas.add(model);
	    }
	    json.put("datas", datas); 
	    json.put("names", names);
	    return json.toString();
	}

	@Override
	public File generateExcel(BitDataModel bitDataModel)
	{
		String fileName ="Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";  
        File outFile=new File(FileHelper.getTmpPath()+File.separator+fileName);
        if(outFile.exists())outFile.delete();
       
		int startNo=Integer.parseInt(bitDataModel.getStartNo());
		int endNo=Integer.parseInt(bitDataModel.getEndNo());
		bitDataModel.setPageNo(startNo);
		int pageSize=(endNo-startNo+1)*bitDataModel.getPageSize();
		bitDataModel.setPageSize(pageSize);
		Pagination pagn=this.bitDataDao.pagnModel(bitDataModel);
		List<BitData> datas=pagn.getResult(BitData.class);
		
		int columnCount=24;
		try{  
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象  
            HSSFSheet sheet = workbook.createSheet("导出数据");                  // 创建工作表  
              
            // 产生表格标题行  
            HSSFRow rowm = sheet.createRow(0);  
            HSSFCell cellTiltle = rowm.createCell(0);  
            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
            cellTiltle.setCellValue("手机品牌"); 
            cellTiltle = rowm.createCell(1);
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
            cellTiltle.setCellValue("手机型号"); 
            cellTiltle = rowm.createCell(2);
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("Android版本"); 
            cellTiltle = rowm.createCell(3); 
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("本机IP"); 
            cellTiltle = rowm.createCell(4);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("IMEI"); 
            cellTiltle = rowm.createCell(5);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("IMSI"); 
            cellTiltle = rowm.createCell(6);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("内存占用率"); 
            cellTiltle = rowm.createCell(7);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CPU使用率"); 
            cellTiltle = rowm.createCell(8);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("运营商"); 
            cellTiltle = rowm.createCell(9);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CID"); 
            cellTiltle = rowm.createCell(10);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("LAC");
            cellTiltle = rowm.createCell(11);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("启动时间");
            cellTiltle = rowm.createCell(12);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("异常时间");
            cellTiltle = rowm.createCell(13);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("上报时间");
            cellTiltle = rowm.createCell(14);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("上报次数");
            cellTiltle = rowm.createCell(15);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("退出时间");
            cellTiltle = rowm.createCell(16);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("运行时间");
            cellTiltle = rowm.createCell(17);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("UID");
            cellTiltle = rowm.createCell(18);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("PID");
            cellTiltle = rowm.createCell(19);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("进程数");
            cellTiltle = rowm.createCell(20);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("GID");
            cellTiltle = rowm.createCell(21);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("应用进程名称");
            cellTiltle = rowm.createCell(22);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("Time");
            cellTiltle = rowm.createCell(23);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("发送总字节量");
            cellTiltle = rowm.createCell(24);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("接收总字节量");
            cellTiltle = rowm.createCell(25);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSRP");
            cellTiltle = rowm.createCell(26);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSRQ");
            cellTiltle = rowm.createCell(27);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("RSSINR");
            cellTiltle = rowm.createCell(28);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("PCI");
            cellTiltle = rowm.createCell(29);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CI");
            cellTiltle = rowm.createCell(30);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("ENODBID");
            cellTiltle = rowm.createCell(31);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("CELLID");
            cellTiltle = rowm.createCell(32);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("TAC");
            cellTiltle = rowm.createCell(33);  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("NetType");
           
        	int j=0;
            //将查询出的数据设置到sheet对应的单元格中  
            for(int i=0;i<datas.size();i++){  
            	BitData data=datas.get(i);
                HSSFRow row = sheet.createRow(j+i+1);//创建所需的行数  
//                HSSFCell  cell = row.createCell(0);   //设置单元格的数据类型  
//                cell.setCellType(HSSFCell.CELL_TYPE_STRING);//设置列头单元格的数据类型  
//                cell.setCellValue(TimeTools.getCnDateTimeStr(data.getLauntime())); 
//                cell.setCellValue(data.getLauntime());                 
                HSSFCell  cell = row.createCell(0); 
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getBrand()); //"手机品牌"
                cell = row.createCell(1);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getType()); //"手机型号"
                cell = row.createCell(2);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getVersion()); //"Android版本"
                cell = row.createCell(3);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getLocalIp()); //"本机IP"
                cellTiltle = row.createCell(4);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getIMEI());//"IMEI"
                cellTiltle = row.createCell(5);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getIMSI());//"IMSI"
                cellTiltle = row.createCell(6);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getMemRate());//"内存占用率"
                cellTiltle = row.createCell(7);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getCpuRate());//"CPU使用率"
               //无线环境信息
                cell = row.createCell(8); 
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getCorporation()); //"运营商"
                cell = row.createCell(9);  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getcId()); //"CellId号"
                cellTiltle = row.createCell(10);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getLac());//"LAC"
                
                //应用业务信息
                cellTiltle = row.createCell(11);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(TimeTools.getCnDateTimeStr(data.getLauntime()));//"启动时间"
                cellTiltle = row.createCell(12);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getExcepTime());//"异常时间"
                cellTiltle = row.createCell(13);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getUploadTime());//"上报时间"
                cellTiltle = row.createCell(14);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getUploadNum());//"上报次数"
                cellTiltle = row.createCell(15);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getExittime());//"退出时间"
                cellTiltle = row.createCell(16);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getUsetime());//"运行时间"
                cellTiltle = row.createCell(17);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getUid());//"UID"
                cellTiltle = row.createCell(18);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getPid());//"PID"
                cellTiltle = row.createCell(19);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getPidNumber());//"进程数"
                cellTiltle = row.createCell(20);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getGid());//"GID"
                cellTiltle = row.createCell(21);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(data.getAppName());//"应用进程名称"
               
                //业务具体信息
                int h=data.getId();
                String s="select * from data1 where ReId="+h+"";
                Jdbc j1=new Jdbc();
                ResultSet rs;
                rs=j1.executeQuery(s);
                if(rs.next())
                {
                	cellTiltle = row.createCell(22);  
            	    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            	    cellTiltle.setCellValue(rs.getString("Time"));//"Time"
            	    cellTiltle = row.createCell(23);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("TxByte"));//"TxByte"
                    cellTiltle = row.createCell(24);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("RxByte"));//"RxByte"
                    cellTiltle = row.createCell(25);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("RSRP"));//"RSRP"
                    cellTiltle = row.createCell(26);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("RSRQ"));//"RSRQ"
                    cellTiltle = row.createCell(27);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("RSSINR"));//"RSSINR"
                    cellTiltle = row.createCell(28);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("PCI"));//"PCI"
                    cellTiltle = row.createCell(29);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("CI"));//"CI"
                    cellTiltle = row.createCell(30);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("ENODBID"));//"ENODBID"
                    cellTiltle = row.createCell(31);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("CELLID"));//"CELLID"
                    cellTiltle = row.createCell(32);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("TAC"));//"TAC"
                    cellTiltle = row.createCell(33);  
                    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cellTiltle.setCellValue(rs.getString("NetType"));//"NetType"
                }
        	    try {
        			while(rs.next()) {
        		HSSFRow row1 = sheet.createRow(i+j+2);
        		cellTiltle = row1.createCell(22);  
        	    cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
        	    cellTiltle.setCellValue(rs.getString("Time"));//"Time"
        	    cellTiltle = row1.createCell(23);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("TxByte"));//"TxByte"
                cellTiltle = row1.createCell(24);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("RxByte"));//"RxByte"
                cellTiltle = row1.createCell(25);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("RSRP"));//"RSRP"
                cellTiltle = row1.createCell(26);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("RSRQ"));//"RSRQ"
                cellTiltle = row1.createCell(27);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("RSSINR"));//"RSSINR"
                cellTiltle = row1.createCell(28);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("PCI"));//"PCI"
                cellTiltle = row1.createCell(29);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("CI"));//"CI"
                cellTiltle = row1.createCell(30);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("ENODBID"));//"ENODBID"
                cellTiltle = row1.createCell(31);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("CELLID"));//"CELLID"
                cellTiltle = row1.createCell(32);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("TAC"));//"TAC"
                cellTiltle = row1.createCell(33);  
                cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
                cellTiltle.setCellValue(rs.getString("NetType"));//"NetType"
                
                j=j+1;
        			}
        		} catch (Exception e) {
        			// TODO: handle exception
        			e.printStackTrace();
        		}
               
                
               
               
               
               
             
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
                	logger.info("outFile.path====={}",outFile.getPath());
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
	public static void main(String[] args)
	{
		List<Integer> lists=new ArrayList<>();
		for(int i=0;i<100;i++)
		{
			lists.add(i);
			
		}
		lists=lists.subList(0, 10);
		for(Integer i:lists)
			System.out.println(i);
	}

	@Override
	public File generateStaticDataExcel(BitDataModel bitDataModel)
	{
		String fileName ="Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";  
        File outFile=new File(FileHelper.getTmpPath()+File.separator+fileName);
        if(outFile.exists())outFile.delete();
       
		List<BitDataView> datas=this.getDataViews(bitDataModel);
		
		int columnCount=3;
		try{  
            HSSFWorkbook workbook = new HSSFWorkbook();                     // 创建工作簿对象  
            HSSFSheet sheet = workbook.createSheet("业务异常统计排名");                  // 创建工作表  
              
            // 产生表格标题行  
            HSSFRow rowm = sheet.createRow(0);  
            HSSFCell cellTiltle = rowm.createCell(0);  
            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】  
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
            cellTiltle.setCellValue("序号"); 
            cellTiltle = rowm.createCell(1);
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("名称"); 
            cellTiltle = rowm.createCell(2); 
            cellTiltle.setCellType(HSSFCell.CELL_TYPE_STRING);
            cellTiltle.setCellValue("数量"); 
        	
            //将查询出的数据设置到sheet对应的单元格中  
            for(int i=0;i<datas.size();i++){  
            	BitDataView data=datas.get(i);
                HSSFRow row = sheet.createRow(i+1);//创建所需的行数  
                HSSFCell  cell = row.createCell(0);   //设置单元格的数据类型  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型  
                cell.setCellValue(String.valueOf(i+1)); 
                cell = row.createCell(1);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getName()); 
                cell = row.createCell(2); 
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(data.getCount()); 
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
//                	logger.info("outFile.path====={}",outFile.getPath());
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
