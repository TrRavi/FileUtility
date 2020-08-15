<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<html>
<head>
    <title>File Operations</title>
    <script src="${contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="${contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="${contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">File Operations</a>
        </li>
    </ul>
</nav>
<div class="row">
    <div class="col-sm-8 offset-sm-2 pt-sm-5">
        <div class="table-responsive">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>File Name</th>
                    <th>Download</th>
                    <th>Copy</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="fileName" items="${fileNames}">
                    <tr>
                        <td>${fileName}</td>
                        <td>
                            <button type="button" class="btn btn-secondary btn-sm downloadFile"  filename="${fileName}">Download</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-secondary btn-sm copyFile"  filename="${fileName}">Copy</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-warning btn-sm deleteFile"  filename="${fileName}">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="application/javascript">
    $(document).ready(function() {
       $(".downloadFile").click(function (){
           let downLoadButton = $(this);
           let fileName = $(this).attr("filename");
           let link = document.createElement('a');
           link.href= "${contextPath}/file/"+fileName;
           link.download = fileName;
           link.click();

       });

        $(".copyFile").click(function (){
            let fileName = $(this).attr("fileName");
            $.ajax({
                url:"${contextPath}/file/"+fileName,
                type:"POST",
                success:function (result){
                    alert(result);
                    location.reload();
                },
                error: function (result){
                    alert(result);
                    //location.reload();
                }
            })

        });

        $(".deleteFile").click(function (){
            let fileName = $(this).attr("fileName");
            $.ajax({
                url:"${contextPath}/file/"+fileName,
                type:"PUT",
                success:function (result){
                    console.log(result);
                    alert(result);
                    location.reload();
                },
                error: function (result){
                    alert(result);
                    location.reload();
                }
            })

        });
    });
</script>


</body>
</html>