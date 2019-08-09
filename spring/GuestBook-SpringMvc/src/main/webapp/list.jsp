<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	div {
		border : 2px solid #666;
		width : 200px;
	}
</style>
</head>
<body>
	
	<H1> 방명록 </H1>
	
	<DIV style="text-align: right;"> <a href="writeForm">글쓰기</a></DIV>
	
	<article id="list">
	
	</article>
	<div id="paging">
	
	</div>
	
		
	
	



<script>

	$(document).ready(function(){
		
		$.ajax({
			url : 'guest/listJson',
			type : 'get',
			data : {page:1},
			success : function(data){
				//alert(data);
				//console.log(data);
				//alert(data.messageTotalCount);
				//alert(JSON.stringify(data));
				
				var output = '';
				
				var list = data.messageList;
				for(var i = 0; i < list.length; i++){
					console.log(list[i]);
					var id = list[i].id;
					var guestName = list[i].guestName;
					var message = list[i].message;
					
					
					output += '<div>\n';
					output += '메시지 번호 : '+id+' <br>\n';
					output += '손님 이름 : '+guestName+' <br>\n';
					output += '메시지 : '+message+'\n';
					output += '</div>\n';
				}
				
				//alert(output);
				
				$('#list').html(output);
				
				
			}
		});
		
		
		
		
	});
	

</script>







</body>
</html>