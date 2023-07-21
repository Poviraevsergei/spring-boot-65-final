<#macro common title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro info user>
    <h2>Id: ${user.getId()}</h2>
    <h2>First name: ${user.getFirstName()}</h2>
    <h2>Last name: ${user.getLastName()}</h2>
    <h2>Created: ${user.getCreatedAt()}</h2>
    <h2>Updated: ${user.getUpdatedAt()}</h2>
    <h2>Role: ${user.getRole()}</h2>
</#macro>

