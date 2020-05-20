<#-- http://freemarker.foofun.cn -->
${name?cap_first}
${brand?upper_case}
${brand?length}
${words?replace("blood", "*****")}
${words?index_of("blood")}
<#-- 利用?string实现三目运算符的操作 -->
${(words?index_of("blood") != -1)?string("包含敏感词汇", "不包含敏感词汇")}

${n?round}
${n?floor}
${n?ceiling}

公司共有${computers?size}台电脑
第一台:${computers?first.model}
最后一台:${computers?last.model}

<#list computers?sort_by("price")?reverse as c>
	${c.sn}-${c.price}
</#list>