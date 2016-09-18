<%@ page contentType="text/html;charset=utf-8"%>
<div id='top'>
	<div class='logo'>
		<ul>
			<li class='sys'>基于LTE-UE-APP实现用户行为与无线环境关联的APP后台系统</li>
			<li class='corp'>中国移动通信集团广西有限公司</li>
		</ul>
	</div>
	<div class='menus'>
		<ul>
			<li class='menu'><a>业务异常事件及其分析<img src='${rootUrl }images/menu_drop.png' /></a>
				<ul>
					<li><a href="${rootUrl }app/common/bitData/index">实时列表</a></li>
					<li><a href="${rootUrl }app/common/bitData/index?hour=ONEHOUR">最近1小时</a></li>
					<li><a href="${rootUrl }app/common/bitData/index?hour=HOUR24">最近24小时</a></li>
				</ul>
			</li>
			<li class='menu'><a>查询及结果分析<img src='${rootUrl }images/menu_drop.png' /></a>
				<ul>
					<li><a href="${rootUrl }app/common/exceptQueryData/index">简单查询</a></li>
					<li><a href="${rootUrl }app/common/exceptQueryComplexData/index">复杂查询</a></li>
				</ul>
			</li>
			<li class='menu'><a href="${rootUrl }app/common/bitData/static">参数统计</a></li>
		   <li class='menu'> <a href="./download.jsp">APP客户端下载</a> 
		    <li class='menu'> <a href="${rootUrl }app/common/bitData/help">帮助</a> 
		   </li>
		</ul>  
	</div>
	<div class='prop'>
		<img src='${rootUrl }images/prop.jpg' />
	</div>
</div>
