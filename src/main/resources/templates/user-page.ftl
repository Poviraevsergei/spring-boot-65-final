<#import "macros/common.ftl" as com>

<@com.common "User page">
    Hello world!
    <h2>Id: ${user.getId()}</h2>
    <h2>First name: ${user.getFirstName()}</h2>
    <h2>Last name: ${user.getLastName()}</h2>
    <h2>Created: ${user.getCreatedAt()}</h2>
    <h2>Updated: ${user.getUpdatedAt()}</h2>
    <h2>Role: ${user.getRole()}</h2>
</@com.common>
