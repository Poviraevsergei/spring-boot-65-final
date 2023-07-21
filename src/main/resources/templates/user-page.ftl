<#import "macros/common.ftl" as com>

<@com.common "User page">
    <#list users as user>
        <@com.info user/>
        <h1>----------------------</h1>
    </#list>
</@com.common>
