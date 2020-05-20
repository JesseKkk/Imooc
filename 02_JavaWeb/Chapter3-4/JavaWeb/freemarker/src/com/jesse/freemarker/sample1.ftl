<#-- FreeMarker取值 -->
${site}
${url}
<#-- !默认值 -->
${author!"不存在的属性"}
<#-- ?string格式化输出 -->
${date?string("yyyy年MM月dd日 HH:mm:ss SSS")}
${number?string("0.00")}
<#if computer.sn == "1234567">
重要设备
</#if>
SN:${computer.sn}
型号:${computer.model}
<#if computer.state == 1>
状态：正在使用
<#elseif computer.state == 2>
状态：闲置
<#elseif computer.state == 3>
状态：已作废
</#if>

<#switch computer.state>
	<#case 1>
		状态：正在使用
		<#break>
	<#case 2>
		状态：闲置
		<#break>
	<#case 3>
		状态：已作废
		<#break>
	<#default>
		状态：无效状态
</#switch>

<#-- ??代表判断对象是否为空,true不为空,false为空 -->
<#if computer.user??>
用户:${computer.user}
</#if>
采购时间:${computer.dop?string("yyyy-MM-dd")}
采购价格:${computer.price?string("0.00")}
配置信息：
--------------
CPU:${computer.info["cpu"]}
内存: ${computer.info["memory"]!"内存不存在!"}