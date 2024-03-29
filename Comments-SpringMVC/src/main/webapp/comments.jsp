<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
</head>
<body onload="showList()">
<div>欢迎：<%=session.getAttribute("userName") %></div>
<a href="ActionServlet?type=logout">注销</a>
<div id="commentsList" ></div>
<div class="addComment">
<div><a href="ActionServlet?type=goPage&page=-1">上一页</a><span ><input id="pageNUM" type="text" value="<%=session.getAttribute("currentPage") %>">/<%=session.getAttribute("totalPage") %></span><a href="ActionServlet?type=goPage&page=<%=session.getAttribute("currentPage") %>">下一页</a></div>
<form id="formComment">
  添加评论：<br />
 <textarea name="content"></textarea><br />
 验证码：<input name="inputCode" value=""/>
    <img src="VerifyCodeServlet" align="middle" title="看不清，请点我"  onclick="javascript:refresh(this);" onmouseover="mouseover(this)"/><br/>
    <button id="btnNewComment">提交</button>
</form>
</div>

</body>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
<script type="text/javascript">
function showList(){
	var clist  ='<%=session.getAttribute("clist") %>';
	var json= JSON.parse(clist)
	console.log(json);
	var commentslist = document.getElementById("commentsList");
	var p="";
	commentslist.innerHTML=null;
	  for(var i in json)  
	  {  
		  p+="<p> "+json[i].id+"   <span>"+json[i].publishTime+"</span><br/><h1>"+json[i].content+"</h1>"+"<p>";
	  }  
	//console.log(p);
	commentslist.innerHTML=p;
}

function refresh(obj){  
    obj.src = "VerifyCodeServlet?" + Math.random();  
}  
 
function mouseover(obj){  
   obj.style.cursor = "pointer";  
}  

</script>
<script type="text/javascript">
$('#pageNUM').on('change',function(){
	
	window.location.href='ActionServlet?type=goPage&page='+($(this).val()-1);
});
$('#btnNewComment').on('click', function() {

    $('#formComment').on('submit', function() {
        var  content = $('textarea').val();

        $(this).ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: 'ActionServlet', // 需要提交的 url
            data: {
                'type': 'newComment',
                'content': content
            },
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                console.log('提交成功！');
                window.location.href='ActionServlet?type=goPage&page=<%=session.getAttribute("totalPage") %>';
                
            $(this).resetForm(); // 提交后重置表单
            }
        });
        return false; // 阻止表单自动提交事件
    });
});
</script>
</html>